/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

public class AutoexecCombopVersionNameRepeatException extends ApiRuntimeException {

    private static final long serialVersionUID = -977867274721886183L;

    private static final String key = "common.errorMessage.reuse.name";

    public AutoexecCombopVersionNameRepeatException(String name) {
        super(key, new JSONObject() {
            {
                this.put("name", name);
            }
        });
    }
}
