/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.notify;

import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.notify.core.INotifyParamHandler;

/**
 * @author laiwt
 * @since 2022/11/14 16:55
 **/
public abstract class AutoexecJobNotifyParamHandlerBase implements INotifyParamHandler {

    @Override
    public Object getText(Object object) {
        if (object instanceof AutoexecJobVo) {
            return getMyText((AutoexecJobVo) object);
        }
        return null;
    }

    public abstract Object getMyText(AutoexecJobVo autoexecJobVo);
}
