/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.autoexec.dto.node;

import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;

/**
 * @author: linbq
 * @since: 2021/4/22 14:58
 **/
public class AutoexecNodeVo implements Serializable {
    private static final long serialVersionUID = -4533004514694610443L;
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "ip地址", type = ApiParamType.STRING)
    private String ip;
    @EntityField(name = "端口号", type = ApiParamType.INTEGER)
    private Integer port;

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

}
