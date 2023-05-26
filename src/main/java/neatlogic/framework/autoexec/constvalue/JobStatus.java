/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.autoexec.dto.job.AutoexecJobStatusVo;
import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum JobStatus implements IEnum {
    SAVED("saved", "enum.autoexec.jobstatus.saved"),
    PENDING("pending", "enum.autoexec.jobstatus.pending"),
    RUNNING("running", "enum.autoexec.jobstatus.running"),
    PAUSING("pausing", "enum.autoexec.jobstatus.pausing"),
    PAUSED("paused", "enum.autoexec.jobstatus.paused"),
    ABORTING("aborting", "enum.autoexec.jobstatus.aborting"),
    ABORTED("aborted", "enum.autoexec.jobstatus.aborted"),
    COMPLETED("completed", "enum.autoexec.jobstatus.completed"),
    FAILED("failed", "enum.autoexec.jobstatus.failed"),
    READY("ready", "enum.autoexec.jobstatus.ready"),
    WAIT_INPUT("waitInput", "enum.autoexec.jobstatus.wait_input"),
    CHECKED("checked", "enum.autoexec.jobstatus.checked"),
    REVOKED("revoked", "enum.autoexec.jobstatus.revoked");
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
        return I18nUtils.getMessage(text);
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
