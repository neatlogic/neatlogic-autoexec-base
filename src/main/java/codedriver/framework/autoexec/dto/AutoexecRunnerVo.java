/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.List;

/**
 * @author lvzk
 * @since 2021/4/12 14:29
 **/
public class AutoexecRunnerVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "代理名", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "代理url", type = ApiParamType.STRING)
    private String url;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "端口", type = ApiParamType.STRING)
    private Integer port;
    @EntityField(name = "代理授权key", type = ApiParamType.STRING)
    private String accessKey;
    @EntityField(name = "代理授权密码", type = ApiParamType.STRING)
    private String accessSecret;
    @EntityField(name = "代理授权类型", type = ApiParamType.STRING)
    private String authType;
    @EntityField(name = "ssh公钥", type = ApiParamType.STRING)
    private String publicKey;
    @EntityField(name = "ssh私钥", type = ApiParamType.STRING)
    private String privateKey;
    @EntityField(name = "代理分组", type = ApiParamType.STRING)
    private List<AutoexecRunnerGroupVo> proxyGroupVoList;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public List<AutoexecRunnerGroupVo> getProxyGroupVoList() {
        return proxyGroupVoList;
    }

    public void setProxyGroupVoList(List<AutoexecRunnerGroupVo> proxyGroupVoList) {
        this.proxyGroupVoList = proxyGroupVoList;
    }
}