/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

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
