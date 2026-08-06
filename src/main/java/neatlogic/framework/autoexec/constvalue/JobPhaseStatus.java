package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.Arrays;
import java.util.List;

public enum JobPhaseStatus implements IEnum {
    PENDING("pending", "term.autoexec.jobstatus.pending"),
    WAITING("waiting", "term.autoexec.jobstatus.queued"),
    RUNNING("running", "term.autoexec.jobstatus.running"),
    PAUSING("pausing", "term.autoexec.jobstatus.pausing"),
    PAUSED("paused", "term.autoexec.jobstatus.paused"),
    ABORTING("aborting", "term.autoexec.jobstatus.aborting"),
    ABORTED("aborted", "common.aborted"),
    COMPLETED("completed", "common.done"),
    FAILED("failed", "term.autoexec.jobstatus.failed"),
    IGNORED("ignored", "term.autoexec.jobstatus.ignored"),
    WAIT_INPUT("waitInput", "term.autoexec.jobstatus.waitinput");
    private final String status;
    private final String text;

    private static final List<String> completedStatusList = Arrays.asList(JobPhaseStatus.IGNORED.getValue(), JobPhaseStatus.COMPLETED.getValue());
    private static final List<String> runningStatusList = Arrays.asList(JobPhaseStatus.ABORTING.getValue(), JobPhaseStatus.PAUSING.getValue(), JobPhaseStatus.PENDING.getValue(), JobPhaseStatus.RUNNING.getValue(), JobPhaseStatus.WAIT_INPUT.getValue(), JobPhaseStatus.WAITING.getValue());
    private static final List<String> failedStatusList = Arrays.asList(JobPhaseStatus.PAUSED.getValue(), JobPhaseStatus.ABORTED.getValue(), JobPhaseStatus.FAILED.getValue());

    JobPhaseStatus(String _status, String _text) {
        this.status = _status;
        this.text = _text;
    }

    public String getValue() {
        return status;
    }

    public String getText() {
        return $.t(text);
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

    public static boolean isRunningStatus(String status) {
        return runningStatusList.contains(status);
    }

    public static boolean isCompletedStatus(String status) {
        return completedStatusList.contains(status);
    }

    public static boolean isFailedStatus(String status) {
        return failedStatusList.contains(status);
    }

}
