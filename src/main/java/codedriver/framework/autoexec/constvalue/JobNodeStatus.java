package codedriver.framework.autoexec.constvalue;

public enum JobNodeStatus {
    PENDING("pending", "未开始", "#8E949F"),
    RUNNING("running", "进行中", "#2d84fb"),
    STOPPING("stopping", "停止中", "#2d84fb"),
    STOPPED("stopped", "已停止", "#8E949F"),
    SUCCEED("succeed", "已成功", "#25b865"),
    FAILED("failed", "已失败", "#f71010"),
    IGNORED("ignored", "已忽略", "#8E949F");
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

}
