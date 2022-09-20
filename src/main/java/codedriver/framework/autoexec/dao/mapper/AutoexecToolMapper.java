/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.AutoexecOperationVo;
import codedriver.framework.autoexec.dto.AutoexecToolVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecToolMapper {

    int checkToolExistsById(Long id);

    List<AutoexecOperationVo> getToolListByIdList(List<Long> idList);

    List<AutoexecOperationVo> getAutoexecOperationListByIdList(List<Long> idList);

    List<AutoexecToolVo> searchTool(AutoexecToolVo toolVo);

    AutoexecToolVo getToolByName(String name);

    List<AutoexecToolVo> getToolByNameList(List<String> toolNameList);

    AutoexecToolVo getToolById(Long id);

    int searchToolCount(AutoexecToolVo toolVo);

    int checkToolHasBeenGeneratedToCombop(Long id);

    List<Long> checkToolListHasBeenGeneratedToCombop(List<Long> idList);

    List<AutoexecToolVo> getAllTool();

    List<Long> getToolIdListByIdListAndTypeId(@Param("idList") List<Long> idList, @Param("typeId") Long typeId);

    int updateActiveStatus(AutoexecToolVo toolVo);

    int updateConfig(AutoexecToolVo toolVo);

    int insertTool(AutoexecToolVo toolVo);

    int deleteToolByIdList(List<Long> list);
}
