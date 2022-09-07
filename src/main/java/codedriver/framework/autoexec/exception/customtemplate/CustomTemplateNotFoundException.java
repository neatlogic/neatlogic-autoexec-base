/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception.customtemplate;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CustomTemplateNotFoundException extends ApiRuntimeException {


    public CustomTemplateNotFoundException(Long id) {
        super("自定义模板“" + id + "”不存在");
    }
}
