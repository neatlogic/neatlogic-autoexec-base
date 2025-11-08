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

import java.util.Arrays;
import java.util.List;

public enum AutoexecJobNotifyTriggerType implements INotifyTriggerType {

    JOB_FAILED("jobfailed", "nfac.autoexecjobnotifytriggertype.text.jobfailed", "nfac.autoexecjobnotifytriggertype.description.jobfailed",
            Arrays.asList(JobStatus.FAILED.getValue())),

    JOB_COMPLETED("jobcompleted", "nfac.autoexecjobnotifytriggertype.text.jobcompleted", "nfac.autoexecjobnotifytriggertype.description.jobcompleted",
            Arrays.asList(JobStatus.COMPLETED.getValue())),

    JOB_WAIT_INPUT("jobwaitinput", "nfac.autoexecjobnotifytriggertype.text.jobwaitinput", "nfac.autoexecjobnotifytriggertype.description.jobwaitinput",
            Arrays.asList(JobStatus.WAIT_INPUT.getValue())),
    ;

    private final String trigger;
    private final String text;
    private final String description;
    private final List<String> jobStatusList;

    AutoexecJobNotifyTriggerType(String _trigger, String _text, String _description, List<String> _jobStatusList) {
        this.trigger = _trigger;
        this.text = _text;
        this.description = _description;
        this.jobStatusList = _jobStatusList;
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
        for (AutoexecJobNotifyTriggerType n : values()) {
            if (n.getTrigger().equals(trigger)) {
                return n.getText();
            }
        }
        return "";
    }

    public static AutoexecJobNotifyTriggerType getTrigger(String trigger) {
        for (AutoexecJobNotifyTriggerType n : values()) {
            if (n.getTrigger().equals(trigger)) {
                return n;
            }
        }
        return null;
    }

    public static AutoexecJobNotifyTriggerType getTriggerByStatus(String status) {
        for (AutoexecJobNotifyTriggerType n : values()) {
            if (n.jobStatusList.contains(status)) {
                return n;
            }
        }
        return null;
    }
}
