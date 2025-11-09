/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.notify;

import neatlogic.framework.autoexec.constvalue.AutoexecJobNotifyTriggerType;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.notify.core.INotifyParamHandler;
import neatlogic.framework.notify.core.INotifyTriggerType;

/**
 * @author laiwt
 * @since 2022/11/14 16:55
 **/
public abstract class AutoexecJobNotifyParamHandlerBase implements INotifyParamHandler {

    @Override
    public Object getText(Object object, INotifyTriggerType notifyTriggerType) {
        if (notifyTriggerType instanceof AutoexecJobNotifyTriggerType && object instanceof AutoexecJobVo) {
            return getMyText((AutoexecJobVo) object);
        }
        return null;
    }

    public abstract Object getMyText(AutoexecJobVo autoexecJobVo);
}
