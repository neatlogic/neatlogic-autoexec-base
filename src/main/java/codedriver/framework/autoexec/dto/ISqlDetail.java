package codedriver.framework.autoexec.dto;

import java.util.Date;

public interface ISqlDetail {

    Long getId();

    Long getResourceId();

    String getSqlFile();

    String getRunnerUrl();

    String getHost();

    Integer getPort();

    String getNodeName();

    String getStatusName();

    String getCostTime();

    Date getStartTime();

    Date getEndTime();

}
