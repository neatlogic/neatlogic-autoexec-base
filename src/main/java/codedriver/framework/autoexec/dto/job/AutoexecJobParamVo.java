/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopParamVo;
import com.alibaba.fastjson.JSONObject;

/**
 * @author lvzk
 * @since 2021/6/4 17:05
 **/
public class AutoexecJobParamVo extends AutoexecCombopParamVo {

    private static final long serialVersionUID = 1249945219289014231L;

    private String value;

    public AutoexecJobParamVo(JSONObject parseObject) {
        this.setName(parseObject.getString("name"));
        this.setKey(parseObject.getString("key"));
        this.setSort(parseObject.getInteger("sort"));
        this.setType(parseObject.getString("type"));
        this.setDescription(parseObject.getString("description"));
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
