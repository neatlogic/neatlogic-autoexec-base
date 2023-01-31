package neatlogic.framework.autoexec.job;

import neatlogic.framework.autoexec.dto.job.AutoexecJobPhaseVo;
import neatlogic.framework.autoexec.dto.job.AutoexecJobVo;
import neatlogic.framework.util.excel.ExcelBuilder;

import java.util.List;
import java.util.Map;

public interface IAutoexecJobPhaseNodeExportHandler {

    String getName();

    /**
     * 导出节点（包含节点输出参数）
     *
     * @param jobVo          作业
     * @param phaseVo        阶段
     * @param outputParamMap 工具与输出参数名称的映射
     * @param excelBuilder   ExcelBuilder
     * @param headList       表头中文名
     * @param columnList     表头英文名
     */
    void exportJobPhaseNodeWithNodeOutputParam(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, Map<String, List<String>> outputParamMap, ExcelBuilder excelBuilder, List<String> headList, List<String> columnList);

    /**
     * 导出节点（包含节点日志）
     *
     * @param jobVo        作业
     * @param phaseVo      阶段
     * @param excelBuilder ExcelBuilder
     * @param headList     表头中文名
     * @param columnList   表头英文名
     */
    void exportJobPhaseNodeWithNodeLog(AutoexecJobVo jobVo, AutoexecJobPhaseVo phaseVo, ExcelBuilder excelBuilder, List<String> headList, List<String> columnList);
}
