package codedriver.framework.autoexec.exception;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AutoexecJobSqlDetailNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 2660806067089897612L;

    public AutoexecJobSqlDetailNotFoundException(Long id){
        super("sql 详情：'" + id + "'不存在");
    }

    public AutoexecJobSqlDetailNotFoundException(){
        super("sql详情不存在");
    }
}
