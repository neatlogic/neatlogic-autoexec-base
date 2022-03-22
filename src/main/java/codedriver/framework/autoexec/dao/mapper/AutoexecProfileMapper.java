package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.profile.AutoexecProfileOperationVo;
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

    List<Long> getAutoexecProfileIdList(AutoexecProfileVo profileVo);

    List<AutoexecProfileVo> searchAutoexecProfile(AutoexecProfileVo profileVo);

    List<AutoexecProfileVo> searchProfileListByIdList(@Param("idList") List<Long> idList);

    List<AutoexecProfileOperationVo> getProfileToolListByProfileId(Long id);

    AutoexecProfileVo getProfileVoById(Long id);

    AutoexecProfileOperationVo getProfileVoByOperateId(Long optionId);//////

    void insertAutoexecProfileTooLByProfileIdAndOperateIdListAndType(@Param("id") Long id, @Param("toolIdList") List<Long> toolIdList, @Param("type") String type);

    void insertProfile(AutoexecProfileVo profileVo);

    void updateProfile(AutoexecProfileVo profileVo);

    void deleteProfileById(Long id);

    void deleteProfileOperateByProfileId(Long id);

}
