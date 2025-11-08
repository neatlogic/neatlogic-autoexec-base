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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.importexport.core.ImportExportHandlerType;
import neatlogic.framework.util.$;

public enum AutoexecImportExportHandlerType implements ImportExportHandlerType {
    AUTOEXEC_CATALOG("autoexecCatalog", "term.autoexec.catalog"),
    AUTOEXEC_CUSTOM_TEMPLATE("autoexecCustomTemplate", "term.autoexec.customtemplate"),
    AUTOEXEC_GLOBAL_PARAM("autoexecGlobalParam", "term.autoexec.globalparam"),
    AUTOEXEC_PROFILE("autoexecProfile", "term.autoexec.profile"),
    AUTOEXEC_RISK("autoexecRisk", "term.autoexec.risk"),
    AUTOEXEC_SCENARIO("autoexecScenario", "term.autoexec.scenario"),
    AUTOEXEC_SCRIPT("autoexecScript", "term.autoexec.script"),
    AUTOEXEC_TOOL("autoexecTool", "term.autoexec.tool"),
    AUTOEXEC_TYPE("autoexecType", "term.autoexec.type"),
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
        return $.t(this.text);
    }
}
