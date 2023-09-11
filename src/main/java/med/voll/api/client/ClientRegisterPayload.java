package med.voll.api.client;

import med.voll.api.address.AddressRegisterPayload;

public record ClientRegisterPayload(
		String name,
		String email,
		String phone,
		AddressRegisterPayload address
		) {

}
