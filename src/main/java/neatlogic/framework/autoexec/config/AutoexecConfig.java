/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.config;

import neatlogic.framework.common.config.IConfigListener;
import neatlogic.framework.util.I18nUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class AutoexecConfig implements IConfigListener {
    private static final Logger logger = LoggerFactory.getLogger(AutoexecConfig.class);
    private static String PROXY_BASIC_USER_NAME;
    private static String PROXY_BASIC_PASSWORD;
    private static Boolean AUTOEXEC_JOB_IS_ALLOWED_MANUAL_TRIGGER_IN_ADVANCE; // 是否允许人工提前触发自动化作业
    private static String AUTOEXEC_TOKEN;// autoexec用户的token


    public static String PROXY_BASIC_USER_NAME() {
        return PROXY_BASIC_USER_NAME;
    }

    public static String PROXY_BASIC_PASSWORD() {
        return PROXY_BASIC_PASSWORD;
    }

    public static Boolean AUTOEXEC_JOB_IS_ALLOWED_MANUAL_TRIGGER_IN_ADVANCE() {
        return AUTOEXEC_JOB_IS_ALLOWED_MANUAL_TRIGGER_IN_ADVANCE;
    }
    public static String AUTOEXEC_TOKEN() {
        return AUTOEXEC_TOKEN;
    }

    @Override
    public void loadConfig(Properties prop) {
        PROXY_BASIC_USER_NAME = prop.getProperty("proxy.basic.username", "neatlogic");
        PROXY_BASIC_PASSWORD = prop.getProperty("proxy.basic.password", "123456");
        AUTOEXEC_JOB_IS_ALLOWED_MANUAL_TRIGGER_IN_ADVANCE = Boolean.valueOf(prop.getProperty("autoexec.job.isallowed.manualtrigger.inadvance", "true"));
        AUTOEXEC_TOKEN = prop.getProperty("autoexec.token");
        if(StringUtils.isBlank(AUTOEXEC_TOKEN)){
            System.out.println(I18nUtils.getStaticMessage("nmac.autoexecconfig.loadconfig.autoexectoken"));
            logger.error(I18nUtils.getStaticMessage("nmac.autoexecconfig.loadconfig.autoexectoken"));
            System.exit(1);
        }
    }
}
