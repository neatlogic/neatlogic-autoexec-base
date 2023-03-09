package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.dependency.core.IFromType;
import neatlogic.framework.util.I18nUtils;

/**
 * @author longrf
 * @date 2021/12/16 4:16 下午
 */
public enum AutoexecFromType implements IFromType {
    AUTOEXEC_CATALOG("autoexeccatalog", "enum.autoexec.autoexecfromtype.autoexec_catalog"),
    AUTOEXEC_PROFILE_OPERATION("autoexecprofileoperation", "enum.autoexec.autoexecfromtype.autoexec_profile_operation"),
    PROFILE("profile", "enum.autoexec.autoexecfromtype.profile"),
    SCRIPT("script", "enum.autoexec.autoexecfromtype.script"),
    TOOL("tool", "enum.autoexec.autoexecfromtype.tool"),
    GLOBAL_PARAM("globalparam", "enum.autoexec.autoexecfromtype.global_param"),
    SCENARIO("scenario", "enum.autoexec.autoexecfromtype.scenario"),
    CUSTOM_TEMPLATE("customtemplate", "enum.autoexec.autoexecfromtype.custom_template"),
    COMBOP("combop", "enum.autoexec.autoexecfromtype.combop"),
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
        return I18nUtils.getMessage(text);
    }
}