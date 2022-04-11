/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.AutoexecOperationVo;
import codedriver.framework.autoexec.dto.AutoexecToolVo;
import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;

import java.util.List;

public interface AutoexecToolMapper {

    int checkToolExistsById(Long id);

    List<AutoexecOperationVo> getToolListByIdList(List<Long> idList);

    List<AutoexecOperationVo> getAutoexecOperationListByIdList(List<Long> idList);

    List<AutoexecToolVo> searchTool(AutoexecToolVo toolVo);

    AutoexecToolVo getToolByName(String name);

    AutoexecToolVo getToolById(Long id);

    int searchToolCount(AutoexecToolVo toolVo);

    int checkToolHasBeenGeneratedToCombop(Long id);

    List<AutoexecToolVo> checkToolListHasBeenGeneratedToCombop(List<Long> idList);

    List<AutoexecCombopVo> getReferenceListByToolId(Long toolId);

    List<AutoexecToolVo> getReferenceCountListByToolIdList(List<Long> idList);

    int updateActiveStatus(AutoexecToolVo toolVo);

    int replaceTool(AutoexecToolVo toolVo);

}
