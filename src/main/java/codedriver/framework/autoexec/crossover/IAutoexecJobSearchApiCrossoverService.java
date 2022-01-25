package codedriver.framework.autoexec.crossover;

import codedriver.framework.crossover.ICrossoverService;
import com.alibaba.fastjson.JSONObject;

/**
 * @author longrf
 * @date 2022/1/24 5:44 下午
 */
public interface IAutoexecJobSearchApiCrossoverService extends ICrossoverService {

    Object myDoService(JSONObject jsonObj) throws Exception;
}
