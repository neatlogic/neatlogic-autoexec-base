package codedriver.framework.autoexec.job.source.action;

import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author longrf
 * @date 2022/5/31 5:12 下午
 */
public abstract class AutoexecJobSourceActionHandlerBase implements IAutoexecJobSourceActionHandler {

    Logger logger = LoggerFactory.getLogger(AutoexecJobSourceActionHandlerBase.class);

    public void getFireParamJson(JSONObject jsonObject, AutoexecJobVo jobVo) {
        getMyFireParamJson(jsonObject, jobVo);
    }

    public void getMyFireParamJson(JSONObject jsonObject, AutoexecJobVo jobVo) {
    }


}
