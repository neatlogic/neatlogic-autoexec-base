/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.constvalue;

public enum JobLogCharset {
    UTF8("UTF-8"),
    GBK("GBK");
    private final String value;

    JobLogCharset(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static JobLogCharset getJobLogCharset(String _value) {
        for (JobLogCharset charset : values()) {
            if (charset.value.equals(_value)) {
                return charset;
            }
        }
        return null;
    }

}
