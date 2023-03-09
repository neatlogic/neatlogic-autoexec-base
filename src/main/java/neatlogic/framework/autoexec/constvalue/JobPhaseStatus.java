package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;

public enum JobPhaseStatus implements IEnum {
    PENDING("pending", "enum.autoexec.jobphasestatus.pending"),
    WAITING("waiting", "enum.autoexec.jobphasestatus.waiting"),
    RUNNING("running", "enum.autoexec.jobphasestatus.running"),
    PAUSING("pausing", "enum.autoexec.jobphasestatus.pausing"),
    PAUSED("paused", "enum.autoexec.jobphasestatus.paused"),
    ABORTING("aborting", "enum.autoexec.jobphasestatus.aborting"),
    ABORTED("aborted", "enum.autoexec.jobphasestatus.aborted"),
    COMPLETED("completed", "enum.autoexec.jobphasestatus.completed"),
    FAILED("failed", "enum.autoexec.jobphasestatus.failed"),
    IGNORED("ignored", "enum.autoexec.jobphasestatus.ignored"),
    WAIT_INPUT("waitInput", "enum.autoexec.jobphasestatus.wait_input");
    private final String status;
    private final String text;

    JobPhaseStatus(String _status, String _text) {
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
        for (JobPhaseStatus s : JobPhaseStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (JobPhaseStatus status : JobPhaseStatus.values()) {
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
