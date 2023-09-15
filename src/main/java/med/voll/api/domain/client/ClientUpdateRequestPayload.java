package med.voll.api.domain.client;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import med.voll.api.domain.address.AddressUpdateRequestPayload;

public record ClientUpdateRequestPayload(
		
		@Size(min = 1, message = "Name cannot be blank")
		String name,
		
		@Size(min = 1, message = "Phone cannot be blank")
		String phone,
		
		@Valid
		AddressUpdateRequestPayload address
		) {

}
