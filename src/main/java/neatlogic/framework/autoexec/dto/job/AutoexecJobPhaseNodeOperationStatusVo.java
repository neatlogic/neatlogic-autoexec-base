/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.dto.job;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.constvalue.JobNodeStatus;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationConfigVo;
import neatlogic.framework.autoexec.dto.combop.AutoexecCombopPhaseOperationVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;


/**
 * @author lvzk
 * @since 2021/5/28 14:58
 **/
public class AutoexecJobPhaseNodeOperationStatusVo {
    @EntityField(name = "作业剧本操作id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业剧本操作名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "作业剧本操作后缀", type = ApiParamType.STRING)
    private String letter;
    @EntityField(name = "作业剧本节点操作类型 script|tool", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "解析器 python|perl等", type = ApiParamType.STRING)
    private String parser;
    @EntityField(name = "执行状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "执行状态名", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "是否失败忽略", type = ApiParamType.INTEGER)
    private Integer failIgnore;
    @EntityField(name = "描述说明", type = ApiParamType.STRING)
    private String description;
    private final Integer sort;
    @EntityField(name = "ifBlock条件", type = ApiParamType.STRING)
    private String condition;
    @EntityField(name = "ifBlock if 工具别表", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseNodeOperationStatusVo> ifList;
    @EntityField(name = "ifBlock else 工具列表", type = ApiParamType.JSONARRAY)
    private List<AutoexecJobPhaseNodeOperationStatusVo> elseList;

    public AutoexecJobPhaseNodeOperationStatusVo(AutoexecJobPhaseOperationVo operationVo, JSONObject statusJson, String description, List<AutoexecJobPhaseOperationVo> jobSonOperationList, Map<String, AutoexecCombopPhaseOperationVo> combopOperationUuidMap) {
        this.id = operationVo.getId();
        this.name = operationVo.getName();
        this.type = operationVo.getType();
        this.parser = operationVo.getParser();
        this.status = JobNodeStatus.PENDING.getValue();
        if (MapUtils.isNotEmpty(statusJson)) {
            this.status = statusJson.getString(this.name + "_" + this.id);
        }
        this.sort = operationVo.getSort();
        this.failIgnore = operationVo.getFailIgnore();
        this.description = StringUtils.isBlank(description) ? StringUtils.EMPTY : description;
        this.letter = operationVo.getLetter();

        //condition
        AutoexecCombopPhaseOperationVo combopOperation = combopOperationUuidMap.get(operationVo.getUuid());
        if (combopOperation != null) {
            AutoexecCombopPhaseOperationConfigVo combopPhaseOperationConfig = combopOperation.getConfig();
            if (combopPhaseOperationConfig != null) {
                String condition = combopPhaseOperationConfig.getCondition();
                if (StringUtils.isNotBlank(condition)) {
                    this.condition = condition;
                    List<AutoexecCombopPhaseOperationVo> combopIfOperationList = combopPhaseOperationConfig.getIfList();
                    List<AutoexecCombopPhaseOperationVo> combopElseOperationList = combopPhaseOperationConfig.getElseList();
                    Map<String, AutoexecCombopPhaseOperationVo> combopSonOperationUuidMap = new HashMap<>();
                    if (CollectionUtils.isNotEmpty(combopIfOperationList)) {
                        combopSonOperationUuidMap.putAll(combopIfOperationList.stream().collect(toMap(AutoexecCombopPhaseOperationVo::getUuid, o -> o)));
                    }
                    if (CollectionUtils.isNotEmpty(combopElseOperationList)) {
                        combopSonOperationUuidMap.putAll(combopElseOperationList.stream().collect(toMap(AutoexecCombopPhaseOperationVo::getUuid, o -> o)));
                    }
                    Map<Long, List<AutoexecJobPhaseOperationVo>> jobSonOperationMap = null;
                    if (CollectionUtils.isNotEmpty(jobSonOperationList)) {
                        jobSonOperationMap = jobSonOperationList.stream().collect(Collectors.groupingBy(AutoexecJobPhaseOperationVo::getParentOperationId));
                        if (MapUtils.isNotEmpty(jobSonOperationMap)) {
                            List<AutoexecJobPhaseOperationVo> jobPhaseSonOperationList = jobSonOperationMap.get(operationVo.getId());
                            if (CollectionUtils.isNotEmpty(jobPhaseSonOperationList)) {
                                ifList = new ArrayList<>();
                                elseList = new ArrayList<>();
                                for (AutoexecJobPhaseOperationVo jobPhaseSonOperation : jobPhaseSonOperationList) {
                                    AutoexecCombopPhaseOperationVo combopSonOperation = combopSonOperationUuidMap.get(jobPhaseSonOperation.getUuid());
                                    if (Objects.equals(jobPhaseSonOperation.getParentOperationType(), "if")) {
                                        ifList.add(new AutoexecJobPhaseNodeOperationStatusVo(statusJson, jobPhaseSonOperation, combopSonOperation == null ? StringUtils.EMPTY : combopSonOperation.getDescription()));
                                    } else {
                                        elseList.add(new AutoexecJobPhaseNodeOperationStatusVo(statusJson, jobPhaseSonOperation, combopSonOperation == null ? StringUtils.EMPTY : combopSonOperation.getDescription()));
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

    }

    public AutoexecJobPhaseNodeOperationStatusVo(JSONObject statusJson, AutoexecJobPhaseOperationVo operationVo, String description) {
        this.id = operationVo.getId();
        this.name = operationVo.getName();
        this.type = operationVo.getType();
        this.parser = operationVo.getParser();
        this.status = JobNodeStatus.PENDING.getValue();
        if (MapUtils.isNotEmpty(statusJson)) {
            this.status = statusJson.getString(this.name + "_" + this.id);
        }
        this.sort = operationVo.getSort();
        this.failIgnore = operationVo.getFailIgnore();
        this.description = StringUtils.isBlank(description) ? StringUtils.EMPTY : description;
        this.letter = operationVo.getLetter();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParser() {
        return parser;
    }

    public void setParser(String parser) {
        this.parser = parser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        if (StringUtils.isBlank(statusName) && StringUtils.isNotBlank(status)) {
            statusName = JobNodeStatus.getText(status);
        }
        return statusName;
    }

    public Integer getSort() {
        return sort;
    }

    public Integer getFailIgnore() {
        return failIgnore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public List<AutoexecJobPhaseNodeOperationStatusVo> getIfList() {
        return ifList;
    }

    public void setIfList(List<AutoexecJobPhaseNodeOperationStatusVo> ifList) {
        this.ifList = ifList;
    }

    public List<AutoexecJobPhaseNodeOperationStatusVo> getElseList() {
        return elseList;
    }

    public void setElseList(List<AutoexecJobPhaseNodeOperationStatusVo> elseList) {
        this.elseList = elseList;
    }
}
