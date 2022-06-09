/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.crossover;

import codedriver.framework.autoexec.dto.combop.AutoexecCombopVo;
import codedriver.framework.autoexec.dto.profile.AutoexecProfileVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author lvzk
 * @since 2021/11/9 15:03
 **/
public interface IAutoexecProfileCrossoverService extends ICrossoverService {



    /**
     * 批量根据profileId列表获取对应的profile列表
     *
     * @param idList profile id列表
     * @return profile列表
     */
    List<AutoexecProfileVo> getProfileVoListByIdList(List<Long> idList);
}
