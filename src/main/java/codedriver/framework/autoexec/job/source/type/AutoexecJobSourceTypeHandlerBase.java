package codedriver.framework.autoexec.job.source.type;

import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.auth.core.AuthActionChecker;
import codedriver.framework.autoexec.dao.mapper.AutoexecJobMapper;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.autoexec.exception.AutoexecJobExecutePermissionDeinedExcpetion;
import com.alibaba.fastjson.JSONObject;
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
    public void executeAuthCheck(Long jobId, Long operationId, String operationType, boolean isTakeOver, String execUser) {
        AutoexecJobVo originJob = autoexecJobMapper.getJobInfo(jobId);
        boolean isCanExecute = AuthActionChecker.checkByUserUuid(UserContext.get().getUserUuid(), getModifyAuthList());
        //创建作业
        if (!isCanExecute && originJob == null) {
            AutoexecJobVo newJob = new AutoexecJobVo(jobId, operationId, operationType);
            myExecuteAuthCheck(newJob, execUser);
        }
        //已存在作业
        if ( originJob != null) {
            if (isTakeOver) {
                myExecuteAuthCheck(originJob, execUser);
                //替换execUser
                originJob.setExecUser(execUser);
                autoexecJobMapper.updateJobExecUser(originJob);
            }else {
                if (!isCanExecute && !execUser.equals(originJob.getExecUser())) {
                    throw new AutoexecJobExecutePermissionDeinedExcpetion(jobId);
                }
            }
        }


    }

    protected void myExecuteAuthCheck(AutoexecJobVo jobVo, String execUser) {
    }

}
