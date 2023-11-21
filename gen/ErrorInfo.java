/**
 * 系统中的错误信息
 */
public enum ErrorInfo {
    /**
     * Unknown Error
     */
    UNKNOWN_ERROR(new MyException("Unknown Error",-1)),
    /**
     * Systen Error
     */
    SYSTEM_ERROR(new MyException("Systen Error",500)),
    /**
     * Unauthorized
     */
    UNAUTHORIZED(new MyException("Unauthorized",401)),

    ;
    private final  MyException exception;

    ErrorInfo(MyException e) {
        exception = e;
    }

    public MyException getException() {
        return exception;
    }
}