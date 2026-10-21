package neatlogic.framework.autoexec.util;

import neatlogic.framework.autoexec.constvalue.ScriptParser;
import neatlogic.framework.exception.file.FilePathIllegalException;
import org.apache.commons.lang3.StringUtils;

/** 操作目录和名称的文件路径格式化，供授权搜索及 Skill 别名共同复用。 */
public final class AutoexecOperationFilePath {
    private AutoexecOperationFilePath() { }

    /** 保留操作名称已有扩展名，否则使用 parser 对应后缀。 */
    public static String build(String catalogPath, String operationName, String parser) {
        String catalog = StringUtils.strip(StringUtils.trimToEmpty(catalogPath).replace('\\', '/'), "/");
        String name = StringUtils.trimToEmpty(operationName);
        if (StringUtils.isBlank(name)) throw new FilePathIllegalException(operationName);
        String path = StringUtils.isBlank(catalog) ? name : catalog + "/" + name;
        if (StringUtils.substringAfterLast("/" + path, "/").lastIndexOf('.') <= 0) {
            ScriptParser type = ScriptParser.getScriptParser(parser);
            path += "." + (type == null ? "tool" : type.getExtension());
        }
        return path;
    }
}
