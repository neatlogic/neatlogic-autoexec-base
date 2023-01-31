/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.profile.AutoexecProfileParamVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAutoexecProfileCrossoverMapper extends ICrossoverService {

    List<AutoexecProfileParamVo> getAllProfileParamList();

    int updateProfileParamPassword(@Param("param") AutoexecProfileParamVo autoexecProfileParamVo,@Param("password") String newPassword);
}
