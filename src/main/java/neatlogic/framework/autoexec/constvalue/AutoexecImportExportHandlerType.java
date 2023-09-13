/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.importexport.core.ImportExportHandlerType;

public enum AutoexecImportExportHandlerType implements ImportExportHandlerType {
    AUTOEXEC_CATALOG("autoexecCatalog", "工具目录"),
    AUTOEXEC_CUSTOM_TEMPLATE("autoexecCustomTemplate", "自定义模板"),
    AUTOEXEC_GLOBAL_PARAM("autoexecGlobalParam", "全局参数"),
    AUTOEXEC_PROFILE("autoexecProfile", "预置参数集"),
    AUTOEXEC_RISK("autoexecRisk", "操作级别"),
    AUTOEXEC_SCENARIO("autoexecScenario", "场景"),
    AUTOEXEC_SCRIPT("autoexecScript", "自定义工具"),
    AUTOEXEC_TOOL("autoexecTool", "工具"),
    AUTOEXEC_TYPE("autoexecType", "工具分类"),
    ;

    private String value;
    private String text;

    AutoexecImportExportHandlerType(String value, String text) {
        this.value = value;
        this.text = text;
    }
    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
