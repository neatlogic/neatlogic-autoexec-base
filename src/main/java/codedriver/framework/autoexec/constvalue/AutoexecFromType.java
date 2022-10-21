package codedriver.framework.autoexec.constvalue;

import codedriver.framework.dependency.core.IFromType;

/**
 * @author longrf
 * @date 2021/12/16 4:16 下午
 */
public enum AutoexecFromType implements IFromType {
    AUTOEXEC_CATALOG("autoexeccatalog", "自动化工具目录"),
    AUTOEXEC_PROFILE_OPERATION("autoexecprofileoperation", "profile自动化工具库工具和自定义工具"),
    PROFILE("profile", "预置参数集"),
    SCRIPT("script", "自定义工具"),
    TOOL("tool", "工具"),
    GLOBAL_PARAM("globalparam", "全局参数"),
    SCENARIO("scenario", "场景"),
    CUSTOM_TEMPLATE("customtemplate", "自定义模版"),
    ;

    private String value;
    private String text;

    AutoexecFromType(String value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 被调用者类型值
     *
     * @return
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * 被调用者类型名
     *
     * @return
     */
    @Override
    public String getText() {
        return text;
    }
}
