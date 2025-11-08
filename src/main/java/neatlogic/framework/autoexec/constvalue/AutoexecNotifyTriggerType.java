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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.notify.core.INotifyTriggerType;
import neatlogic.framework.util.$;

public enum AutoexecNotifyTriggerType implements INotifyTriggerType {

    CREATE_JOB_FAILED("createjobfailed", "nfac.autoexecnotifytriggertype.text.createjobfailed", "nfac.autoexecnotifytriggertype.description.createjobfailed"),
    ;

    private final String trigger;
    private final String text;
    private final String description;

    AutoexecNotifyTriggerType(String _trigger, String _text, String _description) {
        this.trigger = _trigger;
        this.text = _text;
        this.description = _description;
    }

    @Override
    public String getTrigger() {
        return trigger;
    }

    @Override
    public String getText() {
        return $.t(text);
    }

    @Override
    public String getDescription() {
        return $.t(description);
    }

    public static String getText(String trigger) {
        for (AutoexecNotifyTriggerType n : values()) {
            if (n.getTrigger().equals(trigger)) {
                return n.getText();
            }
        }
        return "";
    }

    public static AutoexecNotifyTriggerType getTrigger(String trigger) {
        for (AutoexecNotifyTriggerType n : values()) {
            if (n.getTrigger().equals(trigger)) {
                return n;
            }
        }
        return null;
    }
}
