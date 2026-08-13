/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file in the project root for license information.
 *
 */

package neatlogic.framework.autoexec.dto;

import neatlogic.framework.autoexec.constvalue.AutoexecOperationIndexAction;

import java.io.Serializable;

/** Minimal cross-module description of one committed operation change. */
public class AutoexecOperationChangeVo implements Serializable {
    private static final long serialVersionUID = 6935789388623053343L;

    private String operationType;
    private Long operationId;
    private AutoexecOperationIndexAction action;

    public AutoexecOperationChangeVo() {
    }

    public AutoexecOperationChangeVo(String operationType, Long operationId,
                                     AutoexecOperationIndexAction action) {
        this.operationType = operationType;
        this.operationId = operationId;
        this.action = action;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public AutoexecOperationIndexAction getAction() {
        return action;
    }

    public void setAction(AutoexecOperationIndexAction action) {
        this.action = action;
    }
}
