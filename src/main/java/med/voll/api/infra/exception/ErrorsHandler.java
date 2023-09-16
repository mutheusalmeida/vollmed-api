package med.voll.api.infra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorsHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Void> handle404Error() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<NotValidArgumentResponsePayload> handle400Error(MethodArgumentNotValidException exception) {
		var error = exception.getFieldError();
		
		return ResponseEntity.badRequest().body(new NotValidArgumentResponsePayload(error));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handle400Error(HttpMessageNotReadableException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> handleBadCredentialsError() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	}
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthenticationError() {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Failed to authenticate");
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<String> handleAccessDeniedError() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle500Error(Exception exception) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + exception.getMessage());
	}
}
