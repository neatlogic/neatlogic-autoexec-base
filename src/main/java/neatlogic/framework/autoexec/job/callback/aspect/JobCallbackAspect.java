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

package neatlogic.framework.autoexec.job.callback.aspect;

import neatlogic.framework.asynchronization.thread.NeatLogicThread;
import neatlogic.framework.asynchronization.threadpool.TransactionSynchronizationPool;
import neatlogic.framework.autoexec.annotation.AutoexecJobCallback;
import neatlogic.framework.autoexec.annotation.AutoexecJobCallbackParam;
import neatlogic.framework.autoexec.dao.mapper.AutoexecJobMapper;
import neatlogic.framework.autoexec.dto.job.AutoexecJobInvokeVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.autoexec.job.callback.core.AutoexecJobCallbackFactory;
import neatlogic.framework.autoexec.job.callback.core.IAutoexecJobCallback;
import neatlogic.framework.common.RootComponent;
import org.apache.commons.collections4.MapUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lvzk
 * @since 2021/9/17 16:25
 **/
@Aspect
@RootComponent
public class JobCallbackAspect {
    private final static Logger logger = LoggerFactory.getLogger(JobCallbackAspect.class);
    private static AutoexecJobMapper jobMapper;

    @Autowired
    public void setAutoexecJobMapper(AutoexecJobMapper _jobMapper) {
        jobMapper = _jobMapper;
    }

    @After("@annotation(autoexecJobCallback)")
    public void ActionCheck(JoinPoint point, AutoexecJobCallback autoexecJobCallback) {
        List<IAutoexecJobCallback> callbackList = new ArrayList<>();
        Object[] params = point.getArgs();
        if (params == null || params.length == 0) {
            return;
        }
        // 待处理参数列表
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            Object param = params[i];
            Annotation[] paramAnn = annotations[i];
            // 参数为空或没有注解，直接检查下一个参数
            if (param == null || paramAnn == null) {
                continue;
            }
            for (Annotation annotation : paramAnn) {
                if (annotation instanceof AutoexecJobCallbackParam) {
                    AutoexecJobVo autoexecJobVo = (AutoexecJobVo) param;
                    //仅存在回调且满足条件，才执行回调
                    Map<String, IAutoexecJobCallback> callbackMap = AutoexecJobCallbackFactory.getHandlerMap();
                    if (MapUtils.isNotEmpty(callbackMap)) {
                        for (Map.Entry<String, IAutoexecJobCallback> entry : callbackMap.entrySet()) {
                            IAutoexecJobCallback callback = entry.getValue();
                            if (callback.getIsNeedCallback(autoexecJobVo)) {
                                callbackList.add(callback);
                            }
                        }
                        TransactionSynchronizationPool.execute(new callbackHandler(callbackList, autoexecJobVo));
                    }
                }
            }
        }
    }

    /**
     * 执行callback线程
     */
    private static class callbackHandler extends NeatLogicThread {
        private final AutoexecJobVo jobVo;
        private final List<IAutoexecJobCallback> callbackList;

        public callbackHandler(List<IAutoexecJobCallback> _callbackList, AutoexecJobVo _jobVo) {
            super("AUTOEXEC-JOB-CALLBACK-" + _jobVo.getId());
            callbackList = _callbackList;
            jobVo = _jobVo;
        }

        @Override
        protected void execute() {
            for (IAutoexecJobCallback callback : callbackList) {
                try {
                    AutoexecJobInvokeVo invokeVo = jobMapper.getJobInvokeByJobId(jobVo.getId());
                    callback.doService(invokeVo.getInvokeId(), jobVo);
                }catch (Exception ex){
                    logger.error(ex.getMessage(),ex);
                }
            }
        }

    }
}
