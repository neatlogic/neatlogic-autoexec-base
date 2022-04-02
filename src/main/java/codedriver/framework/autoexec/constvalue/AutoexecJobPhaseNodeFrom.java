package codedriver.framework.autoexec.constvalue;

import codedriver.framework.dependency.core.IFromType;

/**
 * @author longrf
 * @date 2021/12/16 4:16 下午
 */
public enum AutoexecJobPhaseNodeFrom implements IFromType {
    JOB("job","作业全局"),
    GROUP("group","组"),
    PHASE("phase","阶段")
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
        return text;
    }
}
