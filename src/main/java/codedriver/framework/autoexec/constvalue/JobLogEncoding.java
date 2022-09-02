/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

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
