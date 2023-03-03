package neatlogic.framework.autoexec.exception;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AutoexecJobSqlDetailNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 2660806067089897612L;

    public AutoexecJobSqlDetailNotFoundException(){
        super("exception.autoexec.autoexecjobsqldetailnotfoundexception");
    }
}
