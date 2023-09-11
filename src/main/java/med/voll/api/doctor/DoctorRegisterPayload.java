package med.voll.api.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.address.AddressRegisterPayload;

public record DoctorRegisterPayload(
		@NotBlank
		String name,
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String phone,
		
		@NotBlank
		@Pattern(regexp = "\\d{4,6}")
		String crm,
		
		@NotNull
		Specialty specialty,
		
		@NotNull
		@Valid
		AddressRegisterPayload address
) {
	
}
