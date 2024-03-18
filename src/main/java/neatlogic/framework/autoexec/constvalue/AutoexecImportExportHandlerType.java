/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

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
