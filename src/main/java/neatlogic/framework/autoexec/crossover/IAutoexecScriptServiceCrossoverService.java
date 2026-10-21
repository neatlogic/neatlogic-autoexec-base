package neatlogic.framework.autoexec.crossover;

import java.util.List;
import java.util.Map;
import neatlogic.framework.autoexec.dto.AutoexecToolVo;
import neatlogic.framework.autoexec.dto.profile.AutoexecProfileVo;
import neatlogic.framework.autoexec.dto.script.*;
import neatlogic.framework.crossover.ICrossoverService;
import neatlogic.framework.dependency.dto.DependencyInfoVo;

/**
 * @author longrf
 * @date 2022/3/23 10:46 上午
 */
public interface IAutoexecScriptServiceCrossoverService extends ICrossoverService {

    public DependencyInfoVo getScriptDependencyPageUrl(Map<String, Object> map, Long scriptId, String groupName, String pathFormat);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptVo getScriptBaseInfoById(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    List<AutoexecScriptVo> getAutoexecScriptByNameList(List<String> names);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptVo getScriptLockById(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptVersionVo getActiveVersionByScriptId(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptVersionVo getActiveVersionLockByScriptId(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    List<AutoexecScriptVersionParamVo> getParamListByVersionId(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptArgumentVo getArgumentByVersionId(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    List<Long> getLibScriptIdListByVersionId(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecToolVo getToolById(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecToolVo getToolByName(String name);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptVersionVo getScriptVersionDetailByVersionId(Long id);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptVo resolveScriptByName(String name, String catalogPath);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecScriptVo resolveScriptByName(String name, String catalogPath, List<AutoexecScriptVo> candidates);

    /** 复用脚本库的目录创建规则。 */
    Long createCatalogByCatalogPath(String catalogPath);

    /** 复用脚本库的目录定位与查询规则。 */
    AutoexecProfileVo getProfileVoByName(String name);

    /** 在调用方事务内保存独立脚本版本，并沿用原审核、依赖和提交后索引行为。 */
    void importScriptVersion(AutoexecScriptVo script, AutoexecScriptVersionVo version,
                             boolean insert, Long profileId, List<Long> libraries) throws Exception;

    /** 按名称解析已有分类；不创建默认分类。 */
    Long resolveTypeId(String name);

    /** 按名称解析已有操作级别；不创建默认级别。 */
    Long resolveRiskId(String name);
}
