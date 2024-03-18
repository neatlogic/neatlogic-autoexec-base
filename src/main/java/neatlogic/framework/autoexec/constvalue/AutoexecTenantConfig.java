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

import neatlogic.framework.config.ITenantConfig;
import neatlogic.framework.util.$;

public enum AutoexecTenantConfig implements ITenantConfig {
    MAX_NUM_OF_COMBOP_VERSION("maxNumOfCombopVersion", "10", "nfac.autoexectenantconfig.maxnumofcombopversion"),
    AUTOEXEC_JOB_LOG_ENCODING("autoexec.job.log.encoding", null, "nfac.autoexectenantconfig.autoexecjoblogencoding"),
    ;

    String key;
    String value;
    String description;

    AutoexecTenantConfig(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return $.t(description);
    }
}
