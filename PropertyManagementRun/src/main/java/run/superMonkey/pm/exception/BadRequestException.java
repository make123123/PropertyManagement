package run.superMonkey.pm.exception;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author 彭俊豪(Peng Jun Hao)
 *
 */
public class BadRequestException extends PmException {
	
	
	public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
