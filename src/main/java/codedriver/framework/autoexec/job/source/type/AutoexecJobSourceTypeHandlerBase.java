package codedriver.framework.autoexec.job.source.type;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.autoexec.dao.mapper.AutoexecJobMapper;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.autoexec.exception.AutoexecJobExecutePermissionDeniedException;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author longrf
 * @date 2022/5/31 5:12 下午
 */
public abstract class AutoexecJobSourceTypeHandlerBase implements IAutoexecJobSourceTypeHandler {
    protected static AutoexecJobMapper autoexecJobMapper;

    @Autowired
    private void setAutoexecJobMapper(AutoexecJobMapper _autoexecJobMapper) {
        autoexecJobMapper = _autoexecJobMapper;
    }

    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceTypeHandlerBase.class);

    public void getFireParamJson(JSONObject jsonObject, AutoexecJobVo jobVo) {
        getMyFireParamJson(jsonObject, jobVo);
    }

    public void getMyFireParamJson(JSONObject jsonObject, AutoexecJobVo jobVo) {
    }


    @Override
    public void executeAuthCheck(AutoexecJobVo jobParam) {
        Long jobId = jobParam.getId();
        String execUser = StringUtils.isNotBlank(jobParam.getAssignExecUser())?jobParam.getAssignExecUser():UserContext.get().getUserUuid(true);
        jobParam.setExecUser(execUser);
        AutoexecJobVo originJob = autoexecJobMapper.getJobInfo(jobId);
        //作业存在 且 执行人不相等，则需要先接管作业
        if (originJob != null && !execUser.equals(originJob.getExecUser())) {
            //是否需要替换execUser
            if (jobParam.getIsTakeOver() == 1) {
                autoexecJobMapper.updateJobExecUser(jobId, jobParam.getExecUser());
            } else {
                throw new AutoexecJobExecutePermissionDeniedException(jobId);
            }
        }
        myExecuteAuthCheck(jobParam);
    }

    protected void myExecuteAuthCheck(AutoexecJobVo jobParam) {
    }

}
