package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.profile.AutoexecProfileScriptVo;
import codedriver.framework.autoexec.dto.profile.AutoexecProfileToolVo;
import codedriver.framework.autoexec.dto.profile.AutoexecProfileVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author longrf
 * @date 2022/3/16 11:42 上午
 */
public interface AutoexecProfileMapper {
    int searchAutoexecProfileCount(AutoexecProfileVo profileVo);

    int checkProfileIsExists(Long id);

    List<AutoexecProfileVo> searchAutoexecProfile(AutoexecProfileVo profileVo);

    AutoexecProfileVo getProfileVoById(Long id);

    void deleteProfileById(Long id);

    void insertAutoexecProfileTooLByProfileIdAndTooLIdList(@Param("id") Long id, @Param("toolIdList") List<Long> toolIdList);

    void insertAutoexecProfileScriptByProfileIdAndScriptIdList(@Param("id") Long id, @Param("toolIdList") List<Long> toolIdList);

    List<AutoexecProfileToolVo> getProfileToolListByProfileId(Long id);

    List<AutoexecProfileToolVo> getProfileScriptListByProfileId(Long id);

    void insertProfile(AutoexecProfileVo profileVo);

    List<Long> getAutoexecProfileIdList(AutoexecProfileVo profileVo);

    List<AutoexecProfileVo> searchAutoexecProfileListByIdList(@Param("idList") List<Long> idList);

    List<AutoexecProfileToolVo> getProfileToolListByProfileIdList(@Param("profileIdList") List<Long> profileIdList);

    List<AutoexecProfileScriptVo> getProfileScriptListByProfileIdList(@Param("profileIdList") List<Long> profileIdList);
}
