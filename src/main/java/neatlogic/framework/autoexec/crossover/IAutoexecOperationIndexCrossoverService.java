/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file in the project root for license information.
 *
 */

package neatlogic.framework.autoexec.crossover;

import neatlogic.framework.autoexec.dto.AutoexecOperationChangeVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

/** Optional commercial hook for maintaining the Autoexec operation discovery index. */
public interface IAutoexecOperationIndexCrossoverService extends ICrossoverService {
    void recordCommittedChange(List<AutoexecOperationChangeVo> changeList);
}
