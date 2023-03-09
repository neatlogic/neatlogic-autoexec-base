package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;

public enum JobNodeStatus implements IEnum {
    PENDING("pending", "enum.autoexec.jobnodestatus.pending"),
    RUNNING("running", "enum.autoexec.jobnodestatus.running"),
    PAUSING("pausing","enum.autoexec.jobnodestatus.pausing"),
    PAUSED("paused","enum.autoexec.jobnodestatus.paused"),
    ABORTING("aborting", "enum.autoexec.jobnodestatus.aborting"),
    ABORTED("aborted", "enum.autoexec.jobnodestatus.aborted"),
    SUCCEED("succeed", "enum.autoexec.jobnodestatus.succeed"),
    FAILED("failed", "enum.autoexec.jobnodestatus.failed"),
    IGNORED("ignored", "enum.autoexec.jobnodestatus.ignored"),
    WAIT_INPUT("waitInput", "enum.autoexec.jobnodestatus.wait_input");
    private final String status;
    private final String text;

    private JobNodeStatus(String _status, String _text) {
        this.status = _status;
        this.text = _text;
    }

    public String getValue() {
        return status;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public static String getText(String _status) {
        for (JobNodeStatus s : JobNodeStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (JobNodeStatus status : JobNodeStatus.values()) {
            array.add(new JSONObject() {
                private static final long serialVersionUID = 1670544546905960015L;

                {
                    this.put("value", status.getValue());
                    this.put("text", status.getText());
                }
            });
        }
        return array;
    }
}
