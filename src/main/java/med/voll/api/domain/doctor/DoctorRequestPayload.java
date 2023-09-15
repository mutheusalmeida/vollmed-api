package med.voll.api.domain.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import med.voll.api.domain.address.AddressRequestPayload;

public record DoctorRequestPayload(
		
		@Size(min = 1, message = "Name cannot be blank")
		@NotNull(message = "Name is required")
		String name,
		
		@Size(min = 1, message = "Email cannot be blank")
		@NotNull(message = "Email is required")
		@Email(message = "Invalid email")
		String email,
		
		@Size(min = 1, message = "Phone cannot be blank")
		@NotNull(message = "Phone is required")
		String phone,
		
		@Size(min = 1, message = "CRM cannot be blank")
		@NotNull(message = "CRM is required")
		@Pattern(regexp = "\\d{4,6}", message = "Invalid CRM")
		String crm,
		
		@NotNull(message = "Specialty is required")
		Specialty specialty,
		
		@NotNull (message = "An address is required")
		@Valid
		AddressRequestPayload address
) {
	
}
