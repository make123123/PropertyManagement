package run.superMonkey.pm.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception of entity not found.
 *
 * @author 彭俊豪（Peng Jun Hao）
 */
public class NotFoundException extends PmException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}