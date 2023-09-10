package med.voll.api.client;

import med.voll.api.address.Address;

public record ClientRegisterPayload(
		String name,
		String email,
		String phone,
		Address address
		) {

}
