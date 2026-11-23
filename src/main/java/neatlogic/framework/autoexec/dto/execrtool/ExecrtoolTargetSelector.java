package neatlogic.framework.autoexec.dto.execrtool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.node.AutoexecNodeVo;
import neatlogic.framework.cmdb.crossover.IResourceAccountCrossoverMapper;
import neatlogic.framework.cmdb.crossover.IResourceCenterResourceCrossoverService;
import neatlogic.framework.crossover.CrossoverServiceFactory;
import neatlogic.framework.exception.type.ParamIrregularException;
import neatlogic.framework.exception.type.ParamNotExistsException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.function.Consumer;

/** 解析各消费场景共用的资产选择器格式，保留资产定位优先级和筛选结果顺序。 */
public final class ExecrtoolTargetSelector {
    private static final Logger logger = LoggerFactory.getLogger(ExecrtoolTargetSelector.class);
    private ExecrtoolTargetSelector() {}

    /** 拆开选择列表、手工输入和资源过滤器。空行也必须交付一次失败结果。 */
    public static void visit(Object raw, Consumer<Object> accept) {
        if (raw instanceof Collection<?> list && !list.isEmpty()) {
            list.forEach(item -> visit(item, accept));
        } else if (raw instanceof JSONObject obj && (obj.containsKey("selectNodeList") || obj.containsKey("inputNodeList") || obj.containsKey("filter"))) {
            boolean found = false;
            for (String key : List.of("selectNodeList", "inputNodeList")) {
                if (obj.get(key) instanceof Collection<?> list && !list.isEmpty()) {
                    found = true;
                    list.forEach(item -> visit(item, accept));
                }
            }
            if (obj.get("filter") instanceof JSONObject filter && !filter.isEmpty()) {
                List<Long> ids;
                try {
                    IResourceCenterResourceCrossoverService resources = CrossoverServiceFactory.getApi(IResourceCenterResourceCrossoverService.class);
                    var search = resources.assembleResourceSearchVo(new JSONObject(new HashMap<>(filter)));
                    // 资源查询默认分页，不能只执行第一页；先固定本次筛选的有序目标清单。
                    search.setNeedPage(true);
                    search.setMaxPageSize(500);
                    search.setPageSize(500);
                    ids = new ArrayList<>();
                    for (int page = 1; ; page++) {
                        search.setCurrentPage(page);
                        List<Long> batch = resources.getResourceIdList(search);
                        ids.addAll(batch);
                        if (batch.size() < search.getPageSize()) break;
                    }
                } catch (Exception ex) {
                    logger.error("解析工单执行目标过滤器失败", ex);
                    accept.accept(ex);
                    return;
                }
                if (ids.isEmpty()) accept.accept(new ParamNotExistsException("executeNodeConfig.filter"));
                else ids.forEach(accept);
            } else if (!found) accept.accept(null);
        } else if (raw instanceof String str && (str.trim().startsWith("[") || str.trim().startsWith("{"))) {
            Object decoded;
            try {
                decoded = JSON.parse(str);
            } catch (RuntimeException ex) {
                logger.error("解析工单目标 JSON 失败", ex);
                accept.accept(new ParamIrregularException("executeNodeConfig", "JSON"));
                return;
            }
            visit(decoded, accept);
        } else if (raw instanceof String str && str.trim().contains("\n")) {
            str.trim().lines().filter(StringUtils::isNotBlank).forEach(accept);
        } else accept.accept(raw);
    }

    /** 按资源中心协议标识取得下发名称，兼容流程映射使用协议名称。 */
    public static String resolveProtocolName(String protocol) {
        IResourceAccountCrossoverMapper mapper = CrossoverServiceFactory.getApi(IResourceAccountCrossoverMapper.class);
        var protocolVo = StringUtils.isNumeric(protocol) ? mapper.getAccountProtocolVoByProtocolId(Long.valueOf(protocol))
                : mapper.getAccountProtocolVoByProtocolName(protocol);
        if (protocolVo == null) throw new ParamNotExistsException("protocol (" + protocol + ")");
        return protocolVo.getName();
    }

    /** 只复制资产定位字段；不允许工单数据覆写脚本 ID、身份或其他执行参数。 */
    public static String locate(Object raw, ExecrtoolRequest.Item item) {
        JSONObject node;
        if (raw instanceof JSONObject obj) {
            node = obj;
        } else if (raw instanceof Number || raw instanceof String str && StringUtils.isNumeric(str.trim())) {
            node = new JSONObject().fluentPut("resourceId", raw.toString().trim());
        } else if (raw instanceof String str && StringUtils.isNotBlank(str)) {
            node = (JSONObject) JSON.toJSON(new AutoexecNodeVo(str.trim()));
        } else {
            throw new ParamNotExistsException("executeNodeConfig (resourceId / ip)");
        }
        String key = node.containsKey("resourceId") ? "resourceId" : "id";
        item.resourceId = node.getLong(key);
        item.ip = node.getString("ip");
        item.port = node.getInteger("port");
        item.nodeName = node.getString(node.containsKey("nodeName") ? "nodeName" : "name");
        if (StringUtils.isBlank(item.ip) && item.resourceId == null) {
            throw new ParamNotExistsException("executeNodeConfig (resourceId / ip)" + (StringUtils.isBlank(item.nodeName) ? "" : " [" + item.nodeName + "]"));
        }
        return StringUtils.firstNonBlank(item.nodeName, item.ip, node.getString(key));
    }
}
