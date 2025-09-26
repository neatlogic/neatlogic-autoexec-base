/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
    private static Integer RUNNER_CONNECT_TIMEOUT;// runner请求的timeout时间（毫秒）
    private static Integer RUNNER_READ_TIMEOUT;// runner请求的读取timeout时间（毫秒）

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
    public static Integer RUNNER_CONNECT_TIMEOUT() {
        return RUNNER_CONNECT_TIMEOUT;
    }
    public static Integer RUNNER_READ_TIMEOUT() {
        return RUNNER_READ_TIMEOUT;
    }

    @Override
    public void loadConfig(Properties prop) {
        PROXY_BASIC_USER_NAME = prop.getProperty("proxy.basic.username", "neatlogic");
        PROXY_BASIC_PASSWORD = prop.getProperty("proxy.basic.password", "123456");
        AUTOEXEC_JOB_IS_ALLOWED_MANUAL_TRIGGER_IN_ADVANCE = Boolean.valueOf(prop.getProperty("autoexec.job.isallowed.manualtrigger.inadvance", "true"));
        AUTOEXEC_TOKEN = prop.getProperty("autoexec.token");
        RUNNER_CONNECT_TIMEOUT = Integer.valueOf(prop.getProperty("runner.connect.timeout","5000"));
        RUNNER_READ_TIMEOUT = Integer.valueOf(prop.getProperty("runner.read.timeout","15000"));
        if(StringUtils.isBlank(AUTOEXEC_TOKEN)){
            System.out.println(I18nUtils.getStaticMessage("nmac.autoexecconfig.loadconfig.autoexectoken"));
            logger.error(I18nUtils.getStaticMessage("nmac.autoexecconfig.loadconfig.autoexectoken"));
            System.exit(1);
        }
    }
}
