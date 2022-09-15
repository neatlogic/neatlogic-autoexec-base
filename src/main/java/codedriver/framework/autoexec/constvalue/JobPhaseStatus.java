package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum JobPhaseStatus implements IEnum {
    PENDING("pending", "待运行"),
    WAITING("waiting", "排队中"),
    RUNNING("running", "运行中"),
    PAUSING("pausing", "暂停中"),
    PAUSED("paused", "已暂停"),
    ABORTING("aborting", "中止中"),
    ABORTED("aborted", "已中止"),
    COMPLETED("completed", "已完成"),
    FAILED("failed", "已失败"),
    WAIT_INPUT("waitInput", "待输入");
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
        return text;
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
