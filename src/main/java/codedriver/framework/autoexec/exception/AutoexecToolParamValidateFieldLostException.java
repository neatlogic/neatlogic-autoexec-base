/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecToolParamValidateFieldLostException extends ApiRuntimeException {

    private static final long serialVersionUID = 5190517136889826388L;

    public AutoexecToolParamValidateFieldLostException(String param, String field, String lostField) {
        super("参数：'" + param + "'的validate配置中，名称为：" + field + "的规则缺少：" + lostField + "字段");
    }

    public AutoexecToolParamValidateFieldLostException(String param, int fieldIndex, String lostField) {
        super("参数：'" + param + "'的validate配置中，第：" + fieldIndex + " 个的规则缺少：" + lostField + "字段");
    }


}
