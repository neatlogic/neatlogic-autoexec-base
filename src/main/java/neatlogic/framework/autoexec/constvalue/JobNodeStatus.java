package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;

public enum JobNodeStatus implements IEnum {
    PENDING("pending", "待运行"),
    RUNNING("running", "运行中"),
    PAUSING("pausing","暂停中"),
    PAUSED("paused","已暂停"),
    ABORTING("aborting", "中止中"),
    ABORTED("aborted", "已中止"),
    SUCCEED("succeed", "已成功"),
    FAILED("failed", "已失败"),
    IGNORED("ignored", "已忽略"),
    WAIT_INPUT("waitInput", "待输入");
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
