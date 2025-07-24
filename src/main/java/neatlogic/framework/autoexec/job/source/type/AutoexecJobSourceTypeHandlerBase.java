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
import org.apache.commons.lang3.StringUtils;
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
    public void executeAuthCheck(AutoexecJobVo jobParam, boolean isNeedCheckTakeOver) {
        Long jobId = jobParam.getId();
        String execUser = StringUtils.isNotBlank(jobParam.getAssignExecUser()) ? jobParam.getAssignExecUser() : UserContext.get().getUserUuid(true);
        jobParam.setExecUser(execUser);
        if (isNeedCheckTakeOver) {
            AutoexecJobVo originJob = autoexecJobMapper.getJobInfo(jobId);
            //作业存在 且 执行人不相等，则需要先接管作业
            if (originJob != null && !execUser.equals(originJob.getExecUser())) {
                //是否需要替换execUser
                if (jobParam.getIsTakeOver() == 1) {
                    autoexecJobMapper.updateJobExecUser(jobId, jobParam.getExecUser());
                } else {
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
        }
        myExecuteAuthCheck(jobParam);
    }

    protected void myExecuteAuthCheck(AutoexecJobVo jobParam) {
    }


    @Override
    public void overrideProfile(AutoexecJobVo autoexecJobVo, Map<String, AutoexecParamVo> autoexecProfileParamVoMap, Long profileId) {

    }

}
