/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.dto.job;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

/**
 * @author lvzk
 * @since 2021/6/10 14:08
 **/
public class AutoexecJobNodeVo  extends BaseEditorVo {
    @EntityField(name = "作业节点id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "协议id", type = ApiParamType.LONG)
    private Long protocolId;
    @EntityField(name = "执行目标账号", type = ApiParamType.STRING)
    private String userName;
    @EntityField(name = "执行目标账号", type = ApiParamType.STRING)
    private String password;
    @EntityField(name = "作业剧本主机", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "作业剧本主机端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "节点名称", type = ApiParamType.STRING)
    private String nodeName;
    @EntityField(name = "节点类型", type = ApiParamType.STRING)
    private String nodeType;
    @EntityField(name = "资产id", type = ApiParamType.LONG)
    private Long resourceId;


    public AutoexecJobNodeVo() {
    }

    public AutoexecJobNodeVo(String ip, Long jobId, String userName, String protocol) {
        this.host = ip;
        this.jobId = jobId;
        this.userName = userName;
        this.protocol = protocol;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getNodeType() {
        return nodeType;
    }

    public void setNodeType(String nodeType) {
        this.nodeType = nodeType;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}
