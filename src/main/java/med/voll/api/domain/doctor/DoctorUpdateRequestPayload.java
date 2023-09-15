package med.voll.api.domain.doctor;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import med.voll.api.domain.address.AddressUpdateRequestPayload;

public record DoctorUpdateRequestPayload(
		
		@Size(min = 1, message = "Name cannot be blank")
		String name,
		
		@Size(min = 1, message = "Phone cannot be blank")
		@Pattern(regexp = "\\d{11}")
		String phone,
		
		AddressUpdateRequestPayload address
		) {
	
}
