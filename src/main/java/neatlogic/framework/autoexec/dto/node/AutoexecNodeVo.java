/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.autoexec.dto.node;

import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/**
 * @author: linbq
 * @since: 2021/4/22 14:58
 **/
public class AutoexecNodeVo implements Serializable {
    private static final long serialVersionUID = -4533004514694610443L;
    @EntityField(name = "common.id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "term.cmdb.ip", type = ApiParamType.STRING)
    private String ip;
    @EntityField(name = "term.cmdb.port", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "common.typeid", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "common.typename", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "common.typename", type = ApiParamType.STRING)
    private String typeLabel;

    public AutoexecNodeVo() {
    }

    public AutoexecNodeVo(String inputStr) {
        if (inputStr.contains(":")) {
            String[] ipAndportSplit = inputStr.split(":", 2);
            this.ip = ipAndportSplit[0];
            if (ipAndportSplit[1].contains("/")) {
                String[] portAndNameSplit = ipAndportSplit[1].split("/", 2);
                this.port = Integer.valueOf(portAndNameSplit[0]);
                this.name = portAndNameSplit[1];
            } else {
                this.port = Integer.valueOf(ipAndportSplit[1]);
            }
        } else {
            this.ip = inputStr;
        }
    }

    public AutoexecNodeVo(ResourceVo resourceVo) {
        this.id = resourceVo.getId();
        this.name = resourceVo.getName();
        this.ip = resourceVo.getIp();
        this.port = resourceVo.getPort();
        this.typeId = resourceVo.getTypeId();
        this.typeName = resourceVo.getTypeName();
        this.typeLabel = resourceVo.getTypeLabel();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public void setTypeLabel(String typeLabel) {
        this.typeLabel = typeLabel;
    }

    @Override
    public String toString() {
        String str = ip;
        if (port != null) {
            str = str + ":" + port;
            if (StringUtils.isNotBlank(name)) {
                str = str + "/" + name;
            }
        }
        return str;
    }
}
