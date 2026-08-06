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

import neatlogic.framework.util.$;

public enum ScriptVersionStatus {
    DRAFT("draft", "nmautoexec.autoexecskillstatusdraft"),
    SUBMITTED("submitted", "nfac.reviewstatus.waiting"),
    PASSED("passed", "term.diagram.status.passed"),
    REJECTED("rejected", "nmautoexec.autoexecskillstatusrejected"),
    CURRENT("current", "common.active"),
    HISTORY("history", "nmautoexec.autoexecskillhistoricalversion");
    private String value;
    private String text;

    ScriptVersionStatus(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getText(String _value) {
        for (ScriptVersionStatus status : values()) {
            if (status.value.equals(_value)) {
                return status.getText();
            }
        }
        return "";
    }

}
