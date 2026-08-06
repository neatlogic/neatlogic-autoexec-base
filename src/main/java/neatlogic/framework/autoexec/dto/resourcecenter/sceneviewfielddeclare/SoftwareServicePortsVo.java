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

package neatlogic.framework.autoexec.dto.resourcecenter.sceneviewfielddeclare;

import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

@ResourceType(name = "scence_softwareservice_ports", label = "nmar.resource.softwareserviceports", moduleId= "autoexec", functionPathList = {"下载作业剧本节点接口/autoexec/job/phase/nodes/download"})
@ResourceType(name = "scence_osservice_ports", label = "nmar.resource.osserviceports", moduleId= "autoexec", functionPathList = {"下载作业剧本节点接口/autoexec/job/phase/nodes/download"})
public class SoftwareServicePortsVo {
    @EntityField(name = "ID", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;
    @EntityField(name = "service_ports_id", type = ApiParamType.LONG)
    @ResourceField(name = "service_ports_id")
    private Long servicePortsId;
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;
    @EntityField(name = "listen_port", type = ApiParamType.INTEGER)
    @ResourceField(name = "listen_port")
    private Integer listenPort;
}
