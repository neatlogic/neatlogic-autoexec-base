package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum JobPhaseStatus implements IEnum {
    PENDING("pending", "未开始", "#8E949F"),
    WAITING("waiting", "排队中", "#8E949F"),
    RUNNING("running", "进行中", "#2d84fb"),
    PAUSING("pausing", "暂停中", "#2d84fb"),
    PAUSED("paused", "已暂停", "#8E949F"),
    STOPPING("stopping", "停止中", "#2d84fb"),
    STOPPED("stopped", "已停止", "#8E949F"),
    COMPLETED("completed", "已完成", "#25b865"),
    FAILED("failed", "已失败", "#f71010");
    private final String status;
    private final String text;
    private final String color;

    private JobPhaseStatus(String _status, String _text, String _color) {
        this.status = _status;
        this.text = _text;
        this.color = _color;
    }

    public String getValue() {
        return status;
    }

    public String getText() {
        return text;
    }

    public String getColor() {
        return color;
    }

    public static String getText(String _status) {
        for (JobPhaseStatus s : JobPhaseStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    public static String getColor(String _status) {
        for (JobPhaseStatus s : JobPhaseStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getColor();
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
