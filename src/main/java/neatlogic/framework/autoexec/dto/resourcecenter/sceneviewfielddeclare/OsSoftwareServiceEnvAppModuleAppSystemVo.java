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
@ResourceType(name = "scence_os_softwareservice_env_appmodule_appsystem", label = "操作系统与软件服务、环境、模块及应用场景", moduleId= "autoexec")
public class OsSoftwareServiceEnvAppModuleAppSystemVo {
    @EntityField(name = "ID", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;

    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;

    @EntityField(name = "类型ID", type = ApiParamType.LONG)
    @ResourceField(name = "type_id")
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    @ResourceField(name = "type_name")
    private String typeName;
    @EntityField(name = "类型Label", type = ApiParamType.STRING)
    @ResourceField(name = "type_label")
    private String typeLabel;

    @EntityField(name = "资产id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;

    @EntityField(name = "环境ID", type = ApiParamType.LONG)
    @ResourceField(name = "env_id")
    private Long envId;
    @EntityField(name = "环境名称", type = ApiParamType.STRING)
    @ResourceField(name = "env_name")
    private String envName;
    @EntityField(name = "环境序号", type = ApiParamType.INTEGER)
    @ResourceField(name = "env_seq_no")
    private Integer envSeqNo;

    @EntityField(name = "应用模块ID", type = ApiParamType.LONG)
    @ResourceField(name = "app_module_id")
    private Long appModuleId;
    @EntityField(name = "应用模块名", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_name")
    private String appModuleName;
    @EntityField(name = "应用模块简称", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_abbr_name")
    private String appModuleAbbrName;

    @EntityField(name = "应用系统ID", type = ApiParamType.LONG)
    @ResourceField(name = "app_system_id")
    private Long appSystemId;
    @EntityField(name = "应用系统名", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_name")
    private String appSystemName;
    @EntityField(name = "应用系统简称", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_abbr_name")
    private String appSystemAbbrName;
}
