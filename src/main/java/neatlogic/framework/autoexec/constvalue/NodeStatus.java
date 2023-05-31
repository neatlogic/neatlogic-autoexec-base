/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

import neatlogic.framework.util.I18nUtils;

/**
 * @author: linbq
 * @since: 2021/4/23 14:28
 **/
public enum NodeStatus {
    NORMAL("normal", "common.normal", "#25b865"),
    USER_NOT_FOUND("user_not_found", "enum.autoexec.nodestatus.user_not_found","#ffff66"),
    NODE_NOT_FOUND("node_not_found", "enum.autoexec.nodestatus.node_not_found","#f71010");
    private final String value;
    private final String text;
    private final String color;
    private NodeStatus(String value, String text, String color) {
        this.value = value;
        this.text = text;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public String getColor() {
        return color;
    }
}
