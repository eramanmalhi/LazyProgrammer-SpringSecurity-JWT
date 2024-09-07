package lazyprogrammer.jwtdemo.exceptions;

import io.jsonwebtoken.security.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException
            (Exception exception, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", HttpStatus.BAD_REQUEST.value());
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());
        body.put("path", webRequest.getContextPath());
        body.put("sessionId", webRequest.getSessionId());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> handleBadCredentialsException
    (BadCredentialsException badCredentialsException, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", HttpStatus.UNAUTHORIZED.value());
        body.put("timestamp", LocalDateTime.now());
        body.put("message", badCredentialsException.getMessage());
        body.put("path", webRequest.getContextPath());
        body.put("sessionId", webRequest.getSessionId());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidPayloadException.class)
    public ResponseEntity<?> handleInvalidPayloadException
            (InvalidPayloadException invalidPayloadException, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", HttpStatus.BAD_REQUEST.value());
        body.put("timestamp", LocalDateTime.now());
        body.put("message", invalidPayloadException.getMessage());
        body.put("path", webRequest.getContextPath());
        body.put("sessionId", webRequest.getSessionId());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserIdAlreadyExistException.class)
    public ResponseEntity<?> handleUserIdAlreadyExistException
            (UserIdAlreadyExistException userIdAlreadyExistException, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", HttpStatus.BAD_REQUEST.value());
        body.put("timestamp", LocalDateTime.now());
        body.put("message", userIdAlreadyExistException.getMessage());
        body.put("path", webRequest.getContextPath());
        body.put("sessionId", webRequest.getSessionId());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SignatureException.class)
    public ResponseEntity<?> handleSignatureException
            (SignatureException signatureException, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        body.put("code", HttpStatus.UNAUTHORIZED.value());
        body.put("timestamp", LocalDateTime.now());
        body.put("message", signatureException.getMessage());
        body.put("path", webRequest.getContextPath());
        body.put("sessionId", webRequest.getSessionId());
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
