package med.voll.api.client;

import med.voll.api.address.AddressRegisterPayload;

public record ClientUpdatePayload(
		
		String name,
		
		String phone,
		
		AddressRegisterPayload address
		) {

}
