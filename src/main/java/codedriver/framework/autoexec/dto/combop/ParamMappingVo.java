/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.combop;

/**
 * @author: linbq
 * @since: 2021/4/21 18:42
 **/
public class ParamMappingVo {
    private String key;
    private String mappingMode;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMappingMode() {
        return mappingMode;
    }

    public void setMappingMode(String mappingMode) {
        this.mappingMode = mappingMode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
