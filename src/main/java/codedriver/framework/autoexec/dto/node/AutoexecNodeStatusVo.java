/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.autoexec.dto.node;

import codedriver.framework.autoexec.constvalue.NodeStatus;

/**
 * @author: linbq
 * @since: 2021/4/23 14:41
 **/
public class AutoexecNodeStatusVo {
    private String status;
    private String name;
    private String color;

    public AutoexecNodeStatusVo() {
    }

    public AutoexecNodeStatusVo(NodeStatus nodeStatus) {
        this.status = nodeStatus.getValue();
        this.name = nodeStatus.getText();
        this.color = nodeStatus.getColor();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
