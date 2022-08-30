package codedriver.framework.autoexec.dto;

import java.util.Date;

public interface INodeDetail {

    Long getId();

    Long getResourceId();

    String getRunnerUrl();

    String getHost();

    Integer getPort();

    String getNodeName();

    String getStatusName();

    String getCostTime();

    Date getStartTime();

    Date getEndTime();

}
