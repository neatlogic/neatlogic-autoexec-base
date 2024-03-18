/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.constvalue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.autoexec.dto.job.AutoexecJobStatusVo;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.Arrays;
import java.util.List;

public enum JobStatus implements IEnum {
    SAVED("saved", "待提交"),
    PENDING("pending", "待运行"),
    RUNNING("running", "运行中"),
    PAUSING("pausing", "暂停中"),
    PAUSED("paused", "已暂停"),
    ABORTING("aborting", "中止中"),
    ABORTED("aborted", "已中止"),
    COMPLETED("completed", "已完成"),
    FAILED("failed", "已失败"),
    READY("ready", "已就绪"),
    WAIT_INPUT("waitInput", "待输入"),
    CHECKED("checked", "已验证"),
    REVOKED("revoked", "已撤销");
    private final String status;
    private final String text;

    private static List<String> completedStatusList = Arrays.asList(JobStatus.COMPLETED.getValue(), JobStatus.CHECKED.getValue());
    private static List<String> runningStatusList = Arrays.asList(JobStatus.PAUSED.getValue(), JobStatus.PAUSING.getValue(), JobStatus.PENDING.getValue(), JobStatus.READY.getValue(), JobStatus.RUNNING.getValue(), JobStatus.SAVED.getValue(), JobStatus.WAIT_INPUT.getValue());
    private static List<String> failedStatusList = Arrays.asList(JobStatus.ABORTED.getValue(), JobStatus.ABORTING.getValue(), JobStatus.FAILED.getValue(), JobStatus.REVOKED.getValue());

    private JobStatus(String _status, String _text) {
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
        for (JobStatus s : JobStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

    public static AutoexecJobStatusVo getStatus(String _status) {
        for (JobStatus s : JobStatus.values()) {
            if (s.getValue().equals(_status)) {
                AutoexecJobStatusVo jobStatus = new AutoexecJobStatusVo();
                jobStatus.setName(s.getValue());
                jobStatus.setText(s.getText());
                return jobStatus;
            }
        }
        return null;
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (JobStatus status : JobStatus.values()) {
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
