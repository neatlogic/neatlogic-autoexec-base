package codedriver.framework.autoexec.job;

import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseNodeVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import codedriver.framework.autoexec.dto.job.AutoexecJobVo;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface IAutoexecJobPhaseNodeExportHandler {

    String getName();

    /**
     * 导出节点
     *
     * @param jobPhaseNodeVo 用于查询的vo
     * @param jobVo          作业
     * @param phaseVo        阶段
     * @param headList       表头中文名
     * @param columnList     表头英文名
     * @return
     */
    Workbook exportJobPhaseNode(AutoexecJobPhaseNodeVo jobPhaseNodeVo, AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, List<String> headList, List<String> columnList);
}
