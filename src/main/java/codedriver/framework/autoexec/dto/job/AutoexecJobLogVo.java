/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.job;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author lvzk
 * @since 2021/4/27 11:44
 **/
public class AutoexecJobLogVo {
    @EntityField(name = "日志开始下标", type = ApiParamType.INTEGER)
    private Integer startPosition;
    @EntityField(name = "日志结束下标", type = ApiParamType.INTEGER)
    private Integer endPosition;
    @EntityField(name = "日志内容", type = ApiParamType.STRING)
    private String content;

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
