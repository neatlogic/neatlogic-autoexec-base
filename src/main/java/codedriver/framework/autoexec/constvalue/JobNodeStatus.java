package codedriver.framework.autoexec.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum JobNodeStatus  implements IEnum {
    PENDING("pending", "待运行", "#8E949F"),
    RUNNING("running", "运行中", "#2d84fb"),
    ABORTING("aborting", "中止中", "#2d84fb"),
    ABORTED("aborted", "已中止", "#8E949F"),
    SUCCEED("succeed", "已成功", "#25b865"),
    FAILED("failed", "已失败", "#f71010"),
    IGNORED("ignored", "已忽略", "#8E949F"),
    WAIT_INPUT("waitInput", "待输入", "#8E949F");
    private final String status;
    private final String text;
    private final String color;

    private JobNodeStatus(String _status, String _text, String _color) {
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
        for (JobNodeStatus s : JobNodeStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    public static String getColor(String _status) {
        for (JobNodeStatus s : JobNodeStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getColor();
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
