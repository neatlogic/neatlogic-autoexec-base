/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.crossover.IAutoexecCombopCrossoverMapper;
import codedriver.framework.autoexec.dto.AutoexecParamVo;
import codedriver.framework.autoexec.dto.AutoexecTypeVo;
import codedriver.framework.autoexec.dto.combop.*;
import codedriver.framework.dto.AuthenticationInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author: linbq
 * @since: 2021/4/13 11:05
 **/
public interface AutoexecCombopMapper extends IAutoexecCombopCrossoverMapper {
    int checkAutoexecCombopIsExists(Long id);

    Long checkAutoexecCombopNameIsRepeat(AutoexecCombopVo autoexecCombopVo);

    Long checkAutoexecCombopUkIsRepeat(AutoexecCombopVo autoexecCombopVo);

    Integer getAutoexecCombopIsActiveByIdForUpdate(Long id);

    AutoexecCombopVo getAutoexecCombopById(Long id);

    AutoexecCombopVo getAutoexecCombopByName(String name);

    List<AutoexecCombopVo> getAutoexecCombopByIdList(List<Long> idList);

    int getAutoexecCombopCount(AutoexecCombopVo searchVo);

    List<AutoexecCombopVo> getAutoexecCombopList(AutoexecCombopVo searchVo);

    List<Long> getAutoexecCombopIdList(AutoexecCombopVo searchVo);

    List<AutoexecCombopVo> getAutoexecCombopListByIdList(List<Long> idList);

    List<AutoexecCombopAuthorityVo> getAutoexecCombopAuthorityListByCombopIdAndAction(@Param("combopId") Long combopId, @Param("action") String action);

    List<AutoexecParamVo> getAutoexecCombopParamListByCombopId(Long combopId);

    List<AutoexecCombopParamVo> getAllAutoexecCombopPasswordParamList();

    AutoexecCombopParamVo getAutoexecCombopParamByCombopIdAndKey(@Param("combopId") Long combopId, @Param("key") String key);

    List<String> getAutoexecCombopAuthorityListByCombopIdAndUserUuidAndTeamUuidListAndRoleUuidList(
            @Param("combopId") Long combopId,
            @Param("userUuid") String userUuid,
            @Param("teamUuidList") List<String> teamUuidList,
            @Param("roleUuidList") List<String> roleUuidList
    );

    Set<Long> getExecutableAutoexecCombopIdListByKeywordAndAuthenticationInfo(
            @Param("keyword") String keyword,
            @Param("typeId") Long typeId,
            @Param("authenticationInfoVo") AuthenticationInfoVo authenticationInfoVo
    );

    List<Long> checkAutoexecCombopIdListIsExists(List<Long> idList);

    Long checkItHasBeenGeneratedToCombopByOperationId(Long operationId);

    List<AutoexecTypeVo> getAutoexecTypeListByCombopIdList(@Param("combopIdList") List<Long> combopIdList);

    int insertAutoexecCombop(AutoexecCombopVo autoexecCombopVo);

    int insertAutoexecCombopAuthorityVoList(List<AutoexecCombopAuthorityVo> autoexecCombopAuthorityVoList);

    int insertAutoexecCombopParamVoList(List<AutoexecCombopParamVo> autoexecCombopParamVoList);

    int insertAutoexecOperationGenerateCombop(@Param("combopId") Long combopId, @Param("operationType") String operationType, @Param("operationId") Long operationId);

    int updateAutoexecCombopById(AutoexecCombopVo autoexecCombopVo);

    int updateAutoexecCombopIsActiveById(AutoexecCombopVo autoexecCombopVo);

    int updateAutoexecCombopConfigById(AutoexecCombopVo autoexecCombopVo);

    int updateAutoexecCombopPasswordParam(@Param("param") AutoexecCombopParamVo autoexecCombopParamVo, @Param("password") String password);

    int deleteAutoexecCombopById(Long id);

    int deleteAutoexecCombopAuthorityByCombopId(Long combopId);

    int deleteAutoexecCombopParamByCombopId(Long combopId);

    int deleteAutoexecCombopGroupByCombopId(Long combopId);

    int deleteAutoexecOperationGenerateCombop(Long combopId);
}
