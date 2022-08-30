package codedriver.framework.autoexec.job;

import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface IAutoexecJobPhaseNodeExportHandler {

    String getName();

    Workbook exportJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo, AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<String> headList, List<String> columnList);
}
