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
import neatlogic.framework.autoexec.dto.execrtool.ExecrtoolRequest;
import neatlogic.framework.autoexec.dto.execrtool.ExecrtoolResult;
import neatlogic.framework.crossover.ICrossoverService;
import neatlogic.framework.exception.type.PermissionDeniedException;

public interface IAutoexecScriptExecrtoolCrossoverService extends ICrossoverService {

    /** 为同一 Skill 的多步执行创建隔离资源句柄。 */
    IAutoexecScriptExecutionSession openExecutionSession();

    /** 受理一个目标，提交后同步等待下发结果。 */
    ExecrtoolResult execute(ExecrtoolRequest request) throws Exception;

    /** 整批受理，在事务提交后执行；业务入口提供下发前的来源权限复核。 */
    Long submit(ExecrtoolRequest request, Runnable checkSource) throws Exception;

    /** 根据当前用户及已验证的来源范围读取幂等请求。 */
    Long findInvocation(String source, Long sourceId, Long scopeId, String requestId);

    /** 从已授权的业务对象中查询调用或其某条目标审计。 */
    JSONObject readInvocation(String source, Long sourceId, Long invokeId, Long auditId);

    /** 在来源范围内分页返回目标审计及未完成调用状态。 */
    JSONObject searchInvocations(String source, Long sourceId, String operationType, Long operationId, JSONObject filters);

    JSONObject getAutoexecScriptExecrtoolAuditById(Long auditId);

    /** 校验指定脚本版本已审批通过，并且当前执行人有权执行该脚本。 */
    void requireApprovedScriptVersion(Long versionId);

    /** 返回当前用户可复制执行的输入定义；没有执行资格时返回空。 */
    JSONObject getCopyExecutionDefinition(String type, Long id);

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
