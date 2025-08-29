/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.autoexec.constvalue;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.autoexec.config.AutoexecConfig;
import neatlogic.framework.common.constvalue.systemuser.ISystemUser;
import neatlogic.framework.dto.AuthenticationInfoVo;
import neatlogic.framework.dto.JwtVo;
import neatlogic.framework.dto.UserVo;
import neatlogic.framework.filter.core.LoginAuthHandlerBase;
import neatlogic.framework.util.$;
import neatlogic.framework.util.I18n;
import neatlogic.framework.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public enum SystemUser implements ISystemUser {
    AUTOEXEC("autoexec", "autoexec", new I18n("自动化用户"));

    private final Logger logger = LoggerFactory.getLogger(SystemUser.class);

    private final String userId;
    private final String userUuid;
    private final I18n userName;
    private final AuthenticationInfoVo authenticationInfoVo;

    SystemUser(String userId, String userUuid, I18n userName) {
        this.userId = userId;
        this.userUuid = userUuid;
        this.userName = userName;
        this.authenticationInfoVo = new AuthenticationInfoVo(userUuid);
    }


    @Override
    public List<ISystemUser> getSystemUserList() {
        return Arrays.asList(values());
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public String getUserUuid() {
        return userUuid;
    }

    @Override
    public String getUserName() {
        return $.t(userName.toString());
    }

    @Override
    public String getTimezone() {
        return TimeUtil.ZONE_TIME;
    }

    @Override
    public String getToken() {
        if (Objects.equals(userId, AUTOEXEC.getUserId())) {
            return AutoexecConfig.AUTOEXEC_TOKEN();
        }
        return null;
    }

    @Override
    public UserVo getUserVo() {
        UserVo userVo = new UserVo();
        userVo.setUuid(userUuid);
        userVo.setUserId(userId);
        userVo.setUserName(getUserName());
        userVo.setTenant(TenantContext.get() != null ? TenantContext.get().getTenantUuid() : null);
        userVo.setIsDelete(0);
        userVo.setIsActive(1);
        try {
            JwtVo jwtVo = LoginAuthHandlerBase.buildJwt(userVo);
            String authorization = "Bearer_" + jwtVo.getJwthead() + "." + jwtVo.getJwtbody() + "." + jwtVo.getJwtsign();
            userVo.setAuthorization(authorization);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return userVo;
    }

    @Override
    public UserVo getUserVo(Boolean isNeedJwt) {
        UserVo userVo = new UserVo();
        userVo.setUuid(userUuid);
        userVo.setUserId(userId);
        userVo.setUserName(getUserName());
        userVo.setTenant(TenantContext.get() != null ? TenantContext.get().getTenantUuid() : null);
        userVo.setIsDelete(0);
        userVo.setIsActive(1);
        if (isNeedJwt) {
            try {
                JwtVo jwtVo = LoginAuthHandlerBase.buildJwt(userVo);
                String authorization = "Bearer_" + jwtVo.getJwthead() + "." + jwtVo.getJwtbody() + "." + jwtVo.getJwtsign();
                userVo.setAuthorization(authorization);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return userVo;
    }

    @Override
    public AuthenticationInfoVo getAuthenticationInfoVo() {
        return authenticationInfoVo;
    }

    public String getUserName(String userUuid) {
        for (SystemUser user : values()) {
            if (user.getUserUuid().equals(userUuid)) {
                return user.getUserName();
            }
        }
        return "";
    }
}
