package neatlogic.framework.autoexec.job.source.type;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.autoexec.dao.mapper.AutoexecJobMapper;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.autoexec.exception.AutoexecJobExecutePermissionDeniedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

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
        String execUser = UserContext.get().getUserUuid(true);
        jobParam.setExecUser(execUser);
        //来源功能不一定会带source和parentId,则这里补一下已存在的作业这两个信息
        AutoexecJobVo job = autoexecJobMapper.getJobInfoWithInvoke(jobId);
        //不为空代表不是新建作业
        if (job != null) {
            jobParam.setSource(job.getSource());
            jobParam.setParentId(job.getParentId());
            autoexecTakeOver(job);
            if (!execUser.equals(job.getExecUser())){
                throw new AutoexecJobExecutePermissionDeniedException(jobId, execUser, jobParam.getExecUser());
            }
        }
        myExecuteAuthCheck(jobParam);
    }

    protected void myExecuteAuthCheck(AutoexecJobVo jobParam) {
    }


    @Override
    public void overrideProfile(AutoexecJobVo autoexecJobVo, Map<String, AutoexecParamVo> autoexecProfileParamVoMap, Long profileId) {

    }

}
