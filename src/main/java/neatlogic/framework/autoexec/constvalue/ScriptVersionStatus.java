/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.constvalue;

public enum ScriptVersionStatus {
    DRAFT("draft", "草稿"),
    SUBMITTED("submitted", "待审核"),
    PASSED("passed", "已通过"),
    REJECTED("rejected", "已驳回"),
    CURRENT("current", "激活"),
    HISTORY("history", "历史");
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
        return text;
    }

    public static String getText(String _value) {
        for (ScriptVersionStatus status : values()) {
            if (status.value.equals(_value)) {
                return status.text;
            }
        }
        return "";
    }

}