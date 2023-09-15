package med.voll.api.domain.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import med.voll.api.domain.address.AddressRequestPayload;

public record ClientRequestPayload(
		
		@Size(min = 1, message = "Name cannot be blank")
		@NotNull(message = "Name is required")
		String name,
		
		@Size(min = 1, message = "Email cannot be blank")
		@NotNull(message = "Email is required")
		@Email(message = "Invalid email")
		String email,
		
		@Size(min = 1, message = "CPF cannot be blank")
		@NotNull(message = "CPF is required")
		@Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}", message = "Invalid CPF")
		String cpf,
		
		@Size(min = 1, message = "Phone cannot be blank")
		@NotNull(message = "Phone is required")
		String phone,
		
		@NotNull(message = "An address is required")
		@Valid
		AddressRequestPayload address
		) {

}
