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

package neatlogic.framework.autoexec.constvalue;

import java.util.ArrayList;
import java.util.List;

public enum JobLogEncoding {
    UTF8("UTF-8"),
    GBK("GBK");
    private final String value;

    JobLogEncoding(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JobLogEncoding getJobLogEncoding(String _value) {
        for (JobLogEncoding encoding : values()) {
            if (encoding.value.equals(_value)) {
                return encoding;
            }
        }
        return null;
    }

    public static List<String> getJobLogEncodingValueList() {
        List<String> list = new ArrayList<>();
        for (JobLogEncoding encoding : JobLogEncoding.values()) {
            list.add(encoding.getValue());
        }
        return list;
    }

}
