/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/** 自动化脚本解析器及其对应的文件扩展名。 */
public enum ScriptParser implements IEnum {
    PYTHON("python", "py"),
    RUBY("ruby", "rb"),
    VBS("vbscript", "vbs", "vbscript"),
    PERL("perl", "pl"),
    POWERSHELL("powershell", "ps1"),
    CMD("cmd", "cmd", "bat"),
    BASH("bash", "bash"),
    KSH("ksh", "ksh"),
    CSH("csh", "csh"),
    SH("sh", "sh"),
    JAVASCRIPT("javascript", "js"),
    PACKAGE("package", "zip");
    private final String value;
    private final List<String> extensionList;

    /** 初始化 parser 标识及扩展名，首个扩展名作为新文件的规范扩展名。 */
    ScriptParser(String value, String... extensionArray) {
        this.value = value;
        this.extensionList = Collections.unmodifiableList(Arrays.asList(extensionArray));
    }

    public String getValue() {
        return value;
    }

    public String getExtension() {
        return extensionList.get(0);
    }

    public List<String> getExtensionList() {
        return extensionList;
    }

    /** 根据平台 parser 标识查询枚举。 */
    public static ScriptParser getScriptParser(String value) {
        for (ScriptParser parser : ScriptParser.values()) {
            if (parser.getValue().equals(value)) {
                return parser;
            }
        }
        return null;
    }

    /** 根据文件扩展名查询 parser，兼容带点号和大小写不同的输入。 */
    public static ScriptParser getScriptParserByExtension(String extension) {
        if (extension == null) {
            return null;
        }
        String normalizedExtension = extension.trim().toLowerCase(Locale.ROOT);
        if (normalizedExtension.startsWith(".")) {
            normalizedExtension = normalizedExtension.substring(1);
        }
        for (ScriptParser parser : ScriptParser.values()) {
            if (parser.getExtensionList().contains(normalizedExtension)) {
                return parser;
            }
        }
        return null;
    }

    /** 返回 parser 下拉选项数据。 */
    @Override
    public List getValueTextList() {
        JSONArray resultList = new JSONArray();
        for (ScriptParser e : values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", e.getValue());
            jsonObj.put("text", e.getValue());
            resultList.add(jsonObj);
        }
        return resultList;
    }
}
