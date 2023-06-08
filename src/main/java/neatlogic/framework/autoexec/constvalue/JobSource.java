/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.autoexec.source.IAutoexecJobSource;
import neatlogic.framework.util.$;

public enum JobSource implements IAutoexecJobSource {
    HUMAN("人工", "human"),
    SERVICE("快捷服务", "service"),
    AUTOEXEC_SCHEDULE("定时任务", "autoexecschedule"),
    COMBOP("组合工具", "combop"),
    COMBOP_TEST("组合工具测试", "comboptest"),
    SCRIPT_TEST("自定义工具测试", "scripttest"),
    TOOL_TEST("工具测试", "tooltest"),
    TEST("测试", "test");
    private final String text;
    private final String value;


    JobSource(String _text, String _value) {
        this.text = _text;
        this.value = _value;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getText(String _status) {
        for (JobSource s : JobSource.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    public String getType(){
        return JobSourceType.AUTOEXEC.getValue();
    }

}
