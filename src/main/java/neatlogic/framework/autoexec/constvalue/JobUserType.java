/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.common.constvalue.IUserType;
import neatlogic.framework.dto.UserTypeVo;

import java.util.HashMap;
import java.util.Map;

public enum JobUserType implements IUserType {
    EXEC_USER("execuser", "执行人", true);

    private final String status;
    private final String text;
    private final boolean isShow;

    JobUserType(String _status, String _text, boolean _isShow) {
        this.status = _status;
        this.text = _text;
        this.isShow = _isShow;
    }

    public String getValue() {
        return status;
    }

    public String getText() {
        return text;
    }

    public boolean getIsShow() {
        return isShow;
    }

    public static String getValue(String _status) {
        for (JobUserType s : JobUserType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String _status) {
        for (JobUserType s : JobUserType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }


    @Override
    public UserTypeVo getUserType() {
        UserTypeVo vo = new UserTypeVo();
        vo.setModuleId(getModuleId());
        Map<String, String> map = new HashMap<>();
        for (JobUserType type : JobUserType.values()) {
            map.put(type.getValue(), type.getText());
        }
        vo.setValues(map);
        return vo;
    }

    @Override
    public String getModuleId() {
        return "autoexec";
    }
}
