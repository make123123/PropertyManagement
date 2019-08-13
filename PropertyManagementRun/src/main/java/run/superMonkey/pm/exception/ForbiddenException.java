package run.superMonkey.pm.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends PmException{
	public ForbiddenException(String message) {
        super(message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.FORBIDDEN;
    }
}
