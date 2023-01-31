/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
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
