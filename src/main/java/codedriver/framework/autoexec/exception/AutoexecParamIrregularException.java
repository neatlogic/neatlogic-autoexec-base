/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecParamIrregularException extends ApiRuntimeException {

    private static final long serialVersionUID = 7181234466877341137L;

    public AutoexecParamIrregularException(int position, String key) {
        super("第 [" + position + "] 行参数，'" + key + "'不符合格式要求");
    }
}
