/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dao.mapper;

import codedriver.framework.autoexec.dto.AutoexecTypeAuthVo;
import codedriver.framework.autoexec.dto.AutoexecTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AutoexecTypeMapper {

    AutoexecTypeVo getTypeById(Long id);

    List<AutoexecTypeVo> getTypeListByIdList(List<Long> idList);

    int checkTypeNameIsExists(AutoexecTypeVo vo);

    Long getTypeIdByName(String name);

    int searchTypeCount(AutoexecTypeVo vo);

    List<AutoexecTypeVo> searchType(AutoexecTypeVo vo);

    int checkTypeIsExistsById(Long id);

    /**
     * 检查插件类型是否被工具或脚本引用
     *
     * @param id 类型ID
     * @return 引用次数
     */
    int checkTypeHasBeenReferredById(Long id);

    List<AutoexecTypeVo> getReferenceCountListForTool(List<Long> idList);

    List<AutoexecTypeVo> getReferenceCountListForScript(List<Long> idList);

    List<AutoexecTypeVo> getReferenceCountListForCombop(List<Long> idList);

    List<AutoexecTypeVo> getTypeListByNameList(List<String> nameList);

    List<Long> getHasAuthTypeIdListByTypeIdList(List<Long> idList);

    int insertType(AutoexecTypeVo vo);

    void insertTypeList(List<AutoexecTypeVo> typeList);

    void insertTypeAuthList(List<AutoexecTypeAuthVo> autoexecTypeAuthList);

    void insertBatchTypeAuth(@Param("typeIdList") List<Long> typeIdList, @Param("authType") String authType, @Param("authUuid") String authUuid);

    void insertTypeAuth(AutoexecTypeAuthVo autoexecTypeAuthVo);

    int updateType(AutoexecTypeVo vo);

    int deleteTypeById(Long id);

    void deleteTypeAuthByTypeId(Long id);

}
