package lazyprogrammer.jwtdemo.exceptions;

public class AuthenticationFailedException extends RuntimeException {
    public AuthenticationFailedException(Exception e) {
        super(e.getMessage());
    }
}
