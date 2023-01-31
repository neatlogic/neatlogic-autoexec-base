/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.global.param.AutoexecGlobalParamVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAutoexecGlobalParamCrossoverMapper extends ICrossoverService {
    List<AutoexecGlobalParamVo> getAllPasswordGlobalParam();

    int updateGlobalParamPasswordById(@Param("id") Long id, @Param("password") String password);
}
