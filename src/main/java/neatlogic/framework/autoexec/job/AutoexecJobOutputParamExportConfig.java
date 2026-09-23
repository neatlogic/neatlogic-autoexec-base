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

package neatlogic.framework.autoexec.job;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 作业操作输出参数导出配置，用于控制导出范围并标记需要脱敏的密码字段。
 */
public class AutoexecJobOutputParamExportConfig {

    private final boolean includeAll;
    private final Set<String> includedParamKeySet;
    private final Set<String> passwordParamKeySet;

    /**
     * 创建单个作业操作的导出配置，并复制传入集合以避免外部修改。
     */
    public AutoexecJobOutputParamExportConfig(boolean includeAll, Collection<String> includedParamKeyCollection, Collection<String> passwordParamKeyCollection) {
        this.includeAll = includeAll;
        this.includedParamKeySet = includedParamKeyCollection == null ? Collections.emptySet() : new HashSet<>(includedParamKeyCollection);
        this.passwordParamKeySet = passwordParamKeyCollection == null ? Collections.emptySet() : new HashSet<>(passwordParamKeyCollection);
    }

    /**
     * 判断输出参数是否应写入报告。
     */
    public boolean isIncluded(String paramKey) {
        return includeAll || includedParamKeySet.contains(paramKey);
    }

    /**
     * 判断输出参数是否为需要脱敏的密码类型。
     */
    public boolean isPassword(String paramKey) {
        return passwordParamKeySet.contains(paramKey);
    }
}
