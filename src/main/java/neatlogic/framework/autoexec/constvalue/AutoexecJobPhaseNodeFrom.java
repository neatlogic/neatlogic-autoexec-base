package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.dependency.core.IFromType;
import neatlogic.framework.util.$;

/**
 * @author longrf
 * @date 2021/12/16 4:16 下午
 */
public enum AutoexecJobPhaseNodeFrom implements IFromType {
    JOB("job","nfacv.autoexecjobphasenodefrom.text.job"),
    GROUP("group","nfacv.autoexecjobphasenodefrom.text.group"),
    PHASE("phase","term.autoexec.phase")
    ;


    private String value;
    private String text;

    private AutoexecJobPhaseNodeFrom(String value, String text) {
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
