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
