package run.superMonkey.pm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


/**
 * 
 * @author 彭俊豪(Peng Jun Hao)
 *
 */
public abstract class PmException extends RuntimeException{
	
	/**
     * Error errorData.
     */
    private Object errorData;
	
	
	 public PmException(String message) {
	        super(message);
	    }

	    public PmException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    
	    @NonNull
	    public abstract HttpStatus getStatus();

	    @Nullable
	    public Object getErrorData() {
	        return errorData;
	    }

	    /**
	     * Sets error errorData.
	     *
	     * @param errorData error data
	     * @return current exception.
	     */
	    @NonNull
	    public PmException setErrorData(@Nullable Object errorData) {
	        this.errorData = errorData;
	        return this;
	    }
}
