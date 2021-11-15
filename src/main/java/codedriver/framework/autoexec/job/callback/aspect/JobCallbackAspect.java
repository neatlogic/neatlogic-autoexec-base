/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.job.callback.aspect;

import codedriver.framework.asynchronization.thread.CodeDriverThread;
import codedriver.framework.asynchronization.threadpool.TransactionSynchronizationPool;
import codedriver.framework.autoexec.annotation.AutoexecJobCallback;
import codedriver.framework.autoexec.annotation.AutoexecJobCallbackParam;
import codedriver.framework.autoexec.job.callback.core.AutoexecJobCallbackFactory;
import codedriver.framework.autoexec.job.callback.core.IAutoexecJobCallback;
import codedriver.framework.autoexec.dao.mapper.AutoexecJobMapper;
import codedriver.framework.autoexec.dto.job.AutoexecJobInvokeVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import codedriver.framework.common.RootComponent;
import org.apache.commons.collections4.MapUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
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
            if (param == null || paramAnn == null || paramAnn.length == 0) {
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
    private static class callbackHandler extends CodeDriverThread {
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
                AutoexecJobInvokeVo invokeVo = jobMapper.getJobInvokeByJobId(jobVo.getId());
                callback.doService(invokeVo.getInvokeId(), jobVo);
            }
        }

    }
}
