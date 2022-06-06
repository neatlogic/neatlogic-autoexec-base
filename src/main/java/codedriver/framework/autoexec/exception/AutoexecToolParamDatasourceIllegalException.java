/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecToolParamDatasourceIllegalException extends ApiRuntimeException {

    private static final long serialVersionUID = -7415182960002285047L;

    public AutoexecToolParamDatasourceIllegalException(String param) {
        super("参数：'" + param + "'的数据源格式不正确，正确格式为：[{\"text\":\"是\",\"value\":\"1\"},{\"text\":\"否\",\"value\":\"0\"}]，其中(text的key和value)与(value的key)不能为空");
    }


}
