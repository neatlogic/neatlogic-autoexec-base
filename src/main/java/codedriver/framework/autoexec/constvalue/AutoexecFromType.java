package codedriver.framework.autoexec.constvalue;

import codedriver.framework.dependency.core.IFromType;

/**
 * @author longrf
 * @date 2021/12/16 4:16 下午
 */
public enum AutoexecFromType implements IFromType {
    AUTOEXEC_CATALOG("autoexeccatalog","自动化工具目录"),
    AUTOEXEC_OPERATION_PROFILE("autoexecoperationprofile","自动化工具profile"),
    AUTOEXEC_PROFILE_OPERATION("deployprofileoperation","profile工具库工具和自定义工具"),
    AUTOEXEC_PROFILE_CIENTITY("autoexecprofilecientity","profile配置项"),
    AUTOEXEC_SCENARIO_CIENTITY("deployscenariocientity","发布场景配置项"),
    AUTOEXEC_PROFILE_GLOBAL_PARAM("autoexecprofileglobalparam","profile全局参数");

    private String value;
    private String text;

    private AutoexecFromType(String value, String text) {
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
