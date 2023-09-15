package med.voll.api.infra;

import org.springframework.validation.FieldError;

public record NotValidArgumentResponsePayload(
		String message
		) {
	public NotValidArgumentResponsePayload(FieldError error) {
		this(error.getDefaultMessage());
	}
}
