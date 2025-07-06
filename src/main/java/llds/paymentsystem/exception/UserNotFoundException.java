package llds.paymentsystem.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }
}
