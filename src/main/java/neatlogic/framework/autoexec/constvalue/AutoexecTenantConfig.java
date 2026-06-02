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

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.config.ITenantConfig;
import neatlogic.framework.util.$;

/**
 * Tenant-level configuration keys used by autoexec features.
 */
public enum AutoexecTenantConfig implements ITenantConfig {
    MAX_NUM_OF_COMBOP_VERSION("maxNumOfCombopVersion", "10", "nfac.autoexectenantconfig.maxnumofcombopversion"),
    AUTOEXEC_JOB_LOG_ENCODING("autoexec.job.log.encoding", null, "nfac.autoexectenantconfig.autoexecjoblogencoding"),
    AUTOEXEC_JOB_PARAM_VALID("autoexec.job.param.valid", "1", "启用作业参数校验,默认启动校验"),
    // 只控制 execrtool 同步调用 runner 的等待窗口，不影响正式作业 runner 请求。
    AUTOEXEC_EXECRTOOL_RUNNER_READ_TIMEOUT("autoexec.execrtool.runner.read.timeout", "300000", "execrtool请求runner读取超时时间，单位毫秒，默认5分钟");

    final String key;
    final String value;
    final String description;

    AutoexecTenantConfig(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getDescription() {
        return $.t(description);
    }
}
