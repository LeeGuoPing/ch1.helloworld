package ch1.helloworld.result;
/**
 * 
 * @author liguoping
 *
 * 2018年4月16日-下午3:20:40
 *
 * @function 统一错误码异常
 */
public class GlobalErrorInfoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3216237070303791532L;
	
	
	private ErrorInfoInterface  errorInfo;
	
	public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }
}
