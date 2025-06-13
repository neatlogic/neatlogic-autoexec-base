package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.Arrays;
import java.util.List;

public enum JobNodeStatus implements IEnum {
    PENDING("pending", "待运行"),
    RUNNING("running", "运行中"),
    PAUSING("pausing", "暂停中"),
    PAUSED("paused", "已暂停"),
    ABORTING("aborting", "中止中"),
    ABORTED("aborted", "已中止"),
    SUCCEED("succeed", "已成功"),
    FAILED("failed", "已失败"),
    IGNORED("ignored", "已忽略"),
    WAITING("waiting", "排队中"),
    WAIT_INPUT("waitInput", "待输入"),
    INVALID("invalid", "非法节点");
    private final String status;
    private final String text;

    private static final List<String> completedStatusList = Arrays.asList(JobNodeStatus.SUCCEED.getValue(), JobNodeStatus.IGNORED.getValue());
    private static final List<String> runningStatusList = Arrays.asList(JobNodeStatus.ABORTING.getValue(), JobNodeStatus.PAUSING.getValue(), JobNodeStatus.PENDING.getValue(), JobNodeStatus.RUNNING.getValue(), JobNodeStatus.WAIT_INPUT.getValue(), JobNodeStatus.WAITING.getValue());
    private static final List<String> failedStatusList = Arrays.asList(JobNodeStatus.PAUSED.getValue(), JobNodeStatus.ABORTED.getValue(), JobNodeStatus.FAILED.getValue(), JobNodeStatus.INVALID.getValue());

    private JobNodeStatus(String _status, String _text) {
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
