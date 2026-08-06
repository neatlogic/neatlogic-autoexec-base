package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.dependency.core.IFromType;
import neatlogic.framework.util.$;

/**
 * @author longrf
 * @date 2021/12/16 4:16 下午
 */
public enum AutoexecFromType implements IFromType {
    AUTOEXEC_CATALOG("autoexeccatalog", "nfacv.autoexecfromtype.text.autoexec_catalog"),
    AUTOEXEC_PROFILE_OPERATION("autoexecprofileoperation", "nfacv.autoexecfromtype.text.autoexec_profile_operation"),
    PROFILE("profile", "term.autoexec.profile"),
    SCRIPT("script", "nfacv.autoexecfromtype.text.script"),
    TOOL("tool", "term.autoexec.tool"),
    GLOBAL_PARAM("globalparam", "term.autoexec.globalparam"),
    SCENARIO("scenario", "term.autoexec.scenario"),
    CUSTOM_TEMPLATE("customtemplate", "nfacv.autoexecfromtype.text.custom_template"),
    COMBOP("combop", "term.autoexec.combop"),
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
        return $.t(text);
    }
}
