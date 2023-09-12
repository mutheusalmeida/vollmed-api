package med.voll.api.doctor;

import jakarta.validation.constraints.Pattern;
import med.voll.api.address.AddressRegisterPayload;

public record DoctorUpdatePayload(
		String name,
		
		@Pattern(regexp = "\\d{11}")
		String phone,
		
		AddressRegisterPayload address
		) {
	
}
