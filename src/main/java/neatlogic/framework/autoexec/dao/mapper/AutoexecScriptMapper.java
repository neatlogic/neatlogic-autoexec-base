/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.autoexec.dao.mapper;

import neatlogic.framework.autoexec.dto.AutoexecOperationVo;
import neatlogic.framework.autoexec.dto.AutoexecParamVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseOperationVo;
import neatlogic.framework.autoexec.dto.script.*;
import neatlogic.framework.common.dto.ValueTextVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecScriptMapper {

    AutoexecScriptVo getScriptBaseInfoById(Long id);

    AutoexecScriptVo getScriptBaseInfoByName(String name);

    List<AutoexecScriptVo> getAutoexecScriptByIdList(List<Long> idList);

    List<AutoexecScriptVo> getAutoexecScriptBaseInfoByIdList(List<Long> idList);

    List<AutoexecScriptVo> getAutoexecScriptByNameList(List<String> nameList);

    AutoexecScriptVo getScriptLockById(Long id);

    int checkScriptIsExistsById(Long id);

    int checkScriptNameIsExists(AutoexecScriptVo vo);

    int checkScriptUkIsExists(AutoexecScriptVo vo);

    List<Long> checkScriptIdListExists(List<Long> idList);

    List<AutoexecScriptVo> getScriptListByNameList(@Param("nameList") List<String> nameList);

    List<Long> getScriptIdListByNameList(@Param("nameList") List<String> nameList);

    int checkScriptLineContentHashIsExists(String hash);

    AutoexecScriptVersionVo getVersionByVersionIdForUpdate(Long versionId);

    AutoexecScriptVersionVo getVersionByVersionId(Long versionId);

    AutoexecScriptVersionVo getVersionWithUseLibByVersionId(Long versionId);

    List<AutoexecScriptVersionVo> getVersionByVersionIdList(List<Long> versionIdList);

    Integer getMaxVersionByScriptId(Long id);

    int getVersionCountByScriptId(Long scriptId);

    List<AutoexecScriptVersionVo> getVersionList(AutoexecScriptVersionVo versionVo);

    List<AutoexecScriptVersionVo> getVersionListIncludeLineByScriptId(AutoexecScriptVersionVo vo);

    List<AutoexecScriptVersionVo> getVersionIncludeArgumentByVersionIdList(@Param("idList") List<Long> idList);

    List<AutoexecScriptVersionVo> getVersionIncludeParamByVersionIdList(@Param("idList") List<Long> idList);

    List<AutoexecScriptVersionVo> getVersionIncludeUseLibAndNameByVersionIdList(@Param("idList") List<Long> idList);

    List<AutoexecScriptVersionVo> getActiveVersionListIncludeLineByScriptIdList(List<Long> idList);

    List<AutoexecScriptVersionVo> getActiveVersionIncludeArgumentByScriptIdList(List<Long> idList);

    List<AutoexecScriptVo> getScriptListIncludeActiveVersionParamByScriptIdList(List<Long> idList);

    List<AutoexecScriptVersionVo> getActiveVersionIncludeUseLibAndNameByScriptIdList(List<Long> idList);

    int searchVersionCountForSelect(AutoexecScriptVersionVo vo);

    List<AutoexecScriptVersionVo> searchVersionListForSelect(AutoexecScriptVersionVo vo);

    List<ValueTextVo> getVersionNumberListByScriptId(Long id);

    AutoexecScriptVersionVo getActiveVersionByScriptId(Long scriptId);

    List<AutoexecScriptVersionVo> getActiveVersionListByScriptIdList(List<Long> scriptIdList);

    AutoexecScriptVersionVo getActiveVersionWithUseLibsByScriptId(Long scriptId);

    AutoexecScriptVersionVo getActiveVersionLockByScriptId(Long scriptId);

    Integer getActiveVersionNumberByScriptId(Long scriptId);

    List<AutoexecScriptVo> getActiveVersionNumberListByScriptIdList(List<Long> idList);

    AutoexecScriptVersionVo getLatestVersionByScriptId(Long scriptId);

    AutoexecScriptVersionVo getRecentlyVersionByScriptIdAndStatus(@Param("scriptId") Long scriptId, @Param("status") String status);

    int searchHistoricalVersionCountByScriptIdAndStatus(AutoexecScriptVersionVo versionVo);

    List<AutoexecScriptVersionVo> searchHistoricalVersionListByScriptIdAndStatus(AutoexecScriptVersionVo versionVo);

    List<AutoexecScriptVersionVo> getScriptVersionListByScriptId(Long scriptId);

    List<AutoexecScriptVersionParamVo> getParamListByVersionId(Long versionId);

    List<AutoexecScriptVersionParamVo> getOutputParamListByVersionId(Long versionId);

    List<AutoexecScriptVersionParamVo> getAllPasswordScriptParam();

    List<AutoexecParamVo> getAutoexecParamVoListByVersionId(Long versionId);

    List<AutoexecScriptVersionParamVo> getParamListByVersionIdAndMode(@Param("versionId") Long versionId, @Param("mode") String mode);

    List<AutoexecScriptVersionParamVo> getParamListByScriptId(Long operationId);

    List<AutoexecScriptVersionParamVo> getParamListByScriptVersionId(@Param("versionId") Long versionId);

    List<AutoexecScriptLineVo> getLineListByVersionId(Long versionId);

    int searchScriptCount(AutoexecScriptVo scriptVo);

    List<AutoexecScriptVo> searchScript(AutoexecScriptVo scriptVo);

    int searchScriptAndToolCount(AutoexecOperationVo searchVo);

    List<AutoexecOperationVo> searchScriptAndTool(AutoexecOperationVo searchVo);

    List<AutoexecOperationVo> getScriptListByIdList(List<Long> idList);

    List<AutoexecScriptVo> getScriptByVersionIdList(List<Long> scriptVersionIdList);

    AutoexecScriptVo getScriptByVersionId(Long scriptVersionId);

    /**
     * 根据idList查找AutoexecOperationVoList（不含参数）
     *
     * @param idList
     * @return
     */
    List<AutoexecOperationVo> getAutoexecOperationListByIdList(List<Long> idList);

    /**
     * 根据idList查找AutoexecOperationVoList（仅含OperationId和对应的输入参数）
     *
     * @param idList
     * @return
     */
    List<AutoexecOperationVo> getAutoexecOperationInputParamListByIdList(List<Long> idList);

    List<AutoexecOperationVo> getAutoexecOperationInputParamList(@Param("operationVos") List<AutoexecJobPhaseOperationVo> operationVos);

    /**
     * 根据idList查找AutoexecOperationVoList（仅含OperationId和对应的输入参数）
     *
     * @param idList
     * @return
     */
    List<AutoexecOperationVo> getAutoexecOperationOutputParamListByIdList(List<Long> idList);

    List<Long> getVersionIdListByScriptId(Long scriptId);

    AutoexecScriptAuditVo getScriptAuditByScriptVersionIdAndOperate(@Param("versionId") Long versionId, @Param("operate") String operate);

    String getScriptAuditDetailByHash(String hash);

    /**
     * 检查脚本是否已经被发布为组合工具
     *
     * @param scriptId
     * @return
     */
    int checkScriptHasBeenGeneratedToCombop(Long scriptId);

    List<Long> checkScriptListHasBeenGeneratedToCombop(List<Long> scriptIdList);

    int checkScriptHasSubmittedVersionByScriptId(Long scriptId);

    List<Long> getVersionIdList();

    Long getAutoexecCatalogIdByScriptId(Long scriptId);

    /**
     * 根据工具目录id查询有激活版本的脚本id
     *
     * @param catalogIdList 工具目录id列表
     * @return
     */
    List<Long> getAutoexecScriptIdListWhichHasActiveVersionByCatalogIdList(@Param("catalogIdList") List<Long> catalogIdList);

    AutoexecScriptArgumentVo getArgumentByVersionId(Long versionId);

    /**
     * 根据脚本id集合批量获取当前激活版本的自由参数
     *
     * @param scriptIdList
     * @return
     */
    List<AutoexecOperationVo> getArgumentListByScriptIdList(List<Long> scriptIdList);

    /**
     * 根据状态查询{scriptIdList}中各自最近修改版本的解析器
     *
     * @param scriptIdList
     * @param versionStatus
     * @return
     */
    List<AutoexecScriptVersionVo> getVersionParserByScriptIdListAndVersionStatus(@Param("scriptIdList") List<Long> scriptIdList, @Param("versionStatus") String versionStatus);

    AutoexecScriptVersionVo getVersionByScriptIdAndVersionStatus(@Param("id") Long id, @Param("status") String status);

    List<Long> getLibScriptIdListByVersionId(Long id);

    List<Long> getScriptVersionIdListByLibScriptId(Long id);

    List<Long> getIsLibReferenceScriptIdByScriptIdList(@Param("libScriptIdList") List<Long> libScriptIdList);

    List<Long> getIsLibScriptIdByScriptIdList(@Param("idList") List<Long> idList);

    int updateScriptBaseInfo(AutoexecScriptVo scriptVo);

    int updateScriptVersion(AutoexecScriptVersionVo versionVo);

    int updateScriptVersionParamPassword(@Param("param") AutoexecScriptVersionParamVo param, @Param("password") String password);

    int insertScript(AutoexecScriptVo vo);

    int insertScriptVersion(AutoexecScriptVersionVo versionVo);

    int insertScriptVersionParamList(List<AutoexecScriptVersionParamVo> paramList);

    int insertScriptLineContent(AutoexecScriptLineContentVo contentVo);

    int insertScriptAudit(AutoexecScriptAuditVo auditVo);

    int insertScriptAuditDetail(AutoexecScriptAuditContentVo auditContentVo);

    int insertScriptLineList(List<AutoexecScriptLineVo> lineList);

    int batchInsertScriptVersion(List<AutoexecScriptVersionVo> versionList);

    int insertScriptVersionArgument(AutoexecScriptArgumentVo argumentVo);

    int batchInsertVersionArgument(List<AutoexecScriptArgumentVo> argumentVoList);

    void insertScriptVersionUseLib(@Param("id") Long id, @Param("useLib") List<Long> userLib);

    int deleteParamByVersionId(Long versionId);

    int deleteScriptLineByVersionId(Long versionId);

    int deleteParamByVersionIdList(List<Long> versionId);

    int deleteScriptLineByScriptId(Long scriptId);

    int deleteScriptVersionByScriptId(Long scriptId);

    int deleteScriptAuditByScriptId(Long scriptId);

    int deleteVersionByVersionId(Long versionId);

    int deleteScriptById(Long id);

    int deleteArgumentByVersionId(Long versionId);

    int deleteArgumentByVersionIdList(List<Long> versionIdList);

    void deleteScriptVersionLibByScriptVersionId(Long id);

    void deleteScriptVersionLibByLibScriptId(Long id);

    void deleteScriptVersionLibByScriptId(Long id);

}
