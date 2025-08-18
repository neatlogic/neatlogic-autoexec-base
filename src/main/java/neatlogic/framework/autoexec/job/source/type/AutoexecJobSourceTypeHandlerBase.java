package neatlogic.framework.autoexec.job.source.type;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.autoexec.dao.mapper.AutoexecJobMapper;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.autoexec.exception.AutoexecJobExecutePermissionDeniedException;
import neatlogic.framework.dao.mapper.UserMapper;
import neatlogic.framework.dto.UserVo;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author longrf
 * @date 2022/5/31 5:12 下午
 */
public abstract class AutoexecJobSourceTypeHandlerBase implements IAutoexecJobSourceTypeHandler {
    protected static AutoexecJobMapper autoexecJobMapper;

    protected static UserMapper userMapper;

    @Autowired
    private void setAutoexecJobMapper(AutoexecJobMapper _autoexecJobMapper) {
        autoexecJobMapper = _autoexecJobMapper;
    }

    @Autowired
    private void setUserMapper(UserMapper _userMapper) {
        userMapper = _userMapper;
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
        AutoexecJobVo originJob = autoexecJobMapper.getJobInfoWithInvoke(jobId);
        //不为空代表不是新建作业
        if (originJob != null) {
            jobParam.setSource(originJob.getSource());
            jobParam.setParentId(originJob.getParentId());
            autoexecTakeOver(originJob);
            if (!execUser.equals(originJob.getExecUser())) {
                List<UserVo> userVos = userMapper.getUserByUserUuidList(Arrays.asList(execUser, originJob.getExecUser()));
                String currentUserName = execUser;
                String originUserName = originJob.getExecUser();
                if (CollectionUtils.isNotEmpty(userVos)) {
                    for (UserVo userVo : userVos) {
                        if (Objects.equals(userVo.getUuid(), currentUserName)) {
                            currentUserName = userVo.getName() + "(" + userVo.getUserId() + ")";
                        } else if (Objects.equals(userVo.getUuid(), originUserName)) {
                            originUserName = userVo.getName() + "(" + userVo.getUserId() + ")";
                        }
                    }
                }
                throw new AutoexecJobExecutePermissionDeniedException(jobId, currentUserName, originUserName);
            }
        }
        myExecuteAuthCheck(jobParam);
    }

    protected void myExecuteAuthCheck(AutoexecJobVo jobParam) {
    }


    @Override
    public void overrideProfile(AutoexecJobVo
                                        autoexecJobVo, Map<String, AutoexecParamVo> autoexecProfileParamVoMap, Long profileId) {

    }

}
