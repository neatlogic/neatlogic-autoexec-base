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
 * @since 2021/4/12 14:54
 **/
public class AutoexecRunnerGroupVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "runner 分组名", type = ApiParamType.STRING)
    private String name;

    private List<AutoexecRunnerGroupNetworkVo> networkList;

    private List<AutoexecRunnerMapVo> runnerMapList;

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

    public List<AutoexecRunnerGroupNetworkVo> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(List<AutoexecRunnerGroupNetworkVo> networkList) {
        this.networkList = networkList;
    }

    public List<AutoexecRunnerMapVo> getRunnerMapList() {
        return runnerMapList;
    }

    public void setRunnerMapList(List<AutoexecRunnerMapVo> runnerMapList) {
        this.runnerMapList = runnerMapList;
    }
}
