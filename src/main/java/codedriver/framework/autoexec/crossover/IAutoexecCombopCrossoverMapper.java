/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopParamVo;
import codedriver.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAutoexecCombopCrossoverMapper extends ICrossoverService {
    List<AutoexecCombopParamVo> getAllAutoexecCombopPasswordParamList();

    int updateAutoexecCombopPasswordParam(@Param("param") AutoexecCombopParamVo autoexecCombopParamVo, @Param("password") String password);
}