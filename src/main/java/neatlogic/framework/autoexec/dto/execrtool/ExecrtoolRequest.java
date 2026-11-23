package neatlogic.framework.autoexec.dto.execrtool;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.exception.type.ParamNotExistsException;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

/** 一次直接调用的来源、操作定位和有序执行项，来源信息由消费模块提供。 */
public record ExecrtoolRequest(
        @EntityField(name = "execrtoolinvoke.source", type = ApiParamType.STRING) String source,
        @EntityField(name = "execrtoolinvoke.sourceId", type = ApiParamType.LONG) Long sourceId,
        @EntityField(name = "execrtoolinvoke.scopeId", type = ApiParamType.LONG) Long scopeId,
        @EntityField(name = "execrtoolinvoke.requestId", type = ApiParamType.STRING) String requestId,
        @EntityField(name = "term.autoexec.operationtype", type = ApiParamType.STRING) String operationType,
        @EntityField(name = "term.autoexec.operationid", type = ApiParamType.LONG) Long operationId,
        @EntityField(name = "term.autoexec.operationname", type = ApiParamType.STRING) String operationName,
        @EntityField(name = "term.autoexec.fullcatalogname", type = ApiParamType.STRING) String fullCatalogName,
        @EntityField(name = "execrtoolinvoke.expectedVersion", type = ApiParamType.LONG) Long expectedVersion,
        @EntityField(name = "execrtoolinvoke.items", type = ApiParamType.JSONARRAY) List<Item> items) {

    /** 所有构造路径都校验批次，并固定执行项的顺序。 */
    public ExecrtoolRequest {
        if (items == null || items.isEmpty()) throw new ParamNotExistsException("executeNodeConfig");
        if (StringUtils.isBlank(source)) throw new ParamNotExistsException("source");
        if (StringUtils.isBlank(operationType)) throw new ParamNotExistsException("operationType");
        if (requestId != null && (sourceId == null || scopeId == null)) throw new ParamNotExistsException("sourceId", "scopeId");
        items = List.copyOf(items);
    }

    /** 一个执行项对应一条目标审计；明确区分未指定和关闭标准输出。 */
    public static class Item {
        @EntityField(name = "term.cmdb.resourceid", type = ApiParamType.LONG)
        public Long resourceId;
        @EntityField(name = "term.cmdb.ip", type = ApiParamType.STRING)
        public String ip;
        @EntityField(name = "term.cmdb.port", type = ApiParamType.INTEGER)
        public Integer port;
        @EntityField(name = "term.cmdb.resourcename", type = ApiParamType.STRING)
        public String nodeName;
        @EntityField(name = "term.cmdb.protocol", type = ApiParamType.STRING)
        public String protocol;
        @EntityField(name = "common.username", type = ApiParamType.STRING)
        public String username;
        @EntityField(name = "term.autoexec.runnermappingid", type = ApiParamType.LONG)
        public Long runnerId;
        @EntityField(name = "execrtoolinvoke.runnerName", type = ApiParamType.STRING)
        public String runnerName;
        @EntityField(name = "common.runnergroup", type = ApiParamType.STRING)
        public String runnerGroup;
        @EntityField(name = "common.runnergrouptag", type = ApiParamType.JSONARRAY)
        public List<String> runnerGroupTag;
        @EntityField(name = "execrtoolinvoke.param", type = ApiParamType.JSONOBJECT)
        public JSONObject param;
        @EntityField(name = "term.autoexec.freeparam", type = ApiParamType.NOAUTH)
        public Object argument;
        @EntityField(name = "execrtoolinvoke.includeStdout", type = ApiParamType.BOOLEAN)
        public Boolean includeStdout;

        /** 仅从 REST 请求提取受支持的目标参数，不允许客户端指定内部执行身份或来源。 */
        public static Item from(JSONObject json) {
            Item item = new Item();
            item.resourceId = json.getLong("resourceId");
            item.ip = json.getString("ip");
            item.port = json.getInteger("port");
            item.nodeName = json.getString("nodeName");
            item.protocol = json.getString("protocol");
            item.username = json.getString("username");
            item.runnerId = json.getLong("runnerId");
            item.runnerName = json.getString("runnerName");
            item.runnerGroup = json.getString("runnerGroup");
            item.runnerGroupTag = json.getJSONArray("runnerGroupTag") == null ? null : json.getJSONArray("runnerGroupTag").toJavaList(String.class);
            item.param = json.getJSONObject("param");
            item.argument = json.get("argument");
            item.includeStdout = json.getBoolean("includeStdout");
            return item;
        }
    }

    /** 业务入口提供来源和操作类型，REST 名称定位沿用同一构造器。 */
    public static Builder builder(String source, String type, Long id) {
        return new Builder(source, type, id);
    }

    /** 只收集场景已解析的值，版本、权限和资产检查由执行服务统一完成。 */
    public static final class Builder {
        private final String source;
        private final String type;
        private final Long id;
        private final List<Item> items = new ArrayList<>();
        private Long sourceId, scopeId, version;
        private String requestId, name, catalog;

        private Builder(String source, String type, Long id) {
            this.source = source;
            this.type = type;
            this.id = id;
        }

        /** 登记业务对象和可选的幂等范围。 */
        public Builder origin(Long sourceId, Long scopeId, String requestId) {
            this.sourceId = sourceId;
            this.scopeId = scopeId;
            this.requestId = requestId;
            return this;
        }

        /** ID 未提供时由执行服务按名称、目录定位。 */
        public Builder named(String name, String catalog) {
            this.name = name;
            this.catalog = catalog;
            return this;
        }

        /** 绑定用户确认的脚本版本。 */
        public Builder version(Long version) {
            this.version = version;
            return this;
        }

        /** 按业务选择顺序追加实际执行项。 */
        public Builder add(Item item) {
            if (item == null) throw new ParamNotExistsException("item");
            items.add(item);
            return this;
        }

        /** 空批次不能受理；使用幂等键时必须提供完整业务范围。 */
        public ExecrtoolRequest build() {
            return new ExecrtoolRequest(source, sourceId, scopeId, requestId, type, id, name, catalog, version, items);
        }
    }
}
