/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.autoexec.constvalue.ParamMode;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AutoexecToolVo  extends AutoexecOperationVo{
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "输入参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> inputParamList;
    @EntityField(name = "输出参数列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecParamVo> outputParamList;
    public AutoexecToolVo() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public List<AutoexecParamVo> getInputParamList() {
        JSONObject config = getConfig();
        if (MapUtils.isNotEmpty(config)) {
            JSONArray paramList = config.getJSONArray("paramList");
            if (CollectionUtils.isNotEmpty(paramList)) {
                inputParamList = paramList.toJavaList(AutoexecParamVo.class)
                        .stream()
                        .filter(o -> Objects.equals(o.getMode(), ParamMode.INPUT.getValue()))
                        .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                        .collect(Collectors.toList());
            }
        }
        return inputParamList;
    }

    public List<AutoexecParamVo> getOutputParamList() {
        JSONObject config = getConfig();
        if (MapUtils.isNotEmpty(config)) {
            JSONArray paramList = config.getJSONArray("paramList");
            if (CollectionUtils.isNotEmpty(paramList)) {
                outputParamList = paramList.toJavaList(AutoexecParamVo.class)
                        .stream()
                        .filter(o -> Objects.equals(o.getMode(), ParamMode.OUTPUT.getValue()))
                        .sorted(Comparator.comparing(AutoexecParamVo::getSort))
                        .collect(Collectors.toList());
            }
        }
        return outputParamList;
    }
}
