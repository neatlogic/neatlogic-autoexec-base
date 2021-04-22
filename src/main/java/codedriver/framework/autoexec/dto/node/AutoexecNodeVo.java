/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.node;

/**
 * @author: linbq
 * @since: 2021/4/22 14:58
 **/
public class AutoexecNodeVo {
    private Long id;
    private String name;
    private String host;
    private Integer port;
    private String type;

    public AutoexecNodeVo() {

    }

    public AutoexecNodeVo(Long id, String name, String host, Integer port, String type) {
        this.id = id;
        this.name = name;
        this.host = host;
        this.port = port;
        this.type = type;
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
