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

package neatlogic.framework.autoexec.crossover;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;
import java.util.Map;
import neatlogic.framework.crossover.ICrossoverService;
import neatlogic.framework.exception.type.PermissionDeniedException;

public interface IAutoexecScriptExecrtoolCrossoverService extends ICrossoverService {

    /** 为同一 Skill 的多步执行创建隔离资源句柄。 */
    IAutoexecScriptExecutionSession openExecutionSession();

    Object execAutoexecScriptByTagent(JSONObject paramObj) throws Exception;

    JSONObject execAutoexecScriptByTagentWithAudit(JSONObject paramObj) throws Exception;

    JSONObject getAutoexecScriptExecrtoolAuditById(Long auditId);

    boolean checkAutoexecOperationHasExecrtoolAuthority(String operationType, Long operationId);
    /** 查询有效绑定候选；条件由 Skill 服务端构造，不授予执行权限。 */
    List<Map<String, Object>> searchBindingCandidates(JSONObject condition);
    /** 返回同一候选条件的总数。 */
    int countBindingCandidates(JSONObject condition);
    /** 在原授权校验和去重规则下追加已验证操作的授权。 */
    int appendOperationAuthorities(JSONArray operations, JSONArray targets) throws PermissionDeniedException;
    /** 保留 Skill 执行边界原有的授权指引。 */
    String skillExecutionFailureMessage(Exception exception);
}
