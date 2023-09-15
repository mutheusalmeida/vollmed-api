package med.voll.api.domain.client;

import med.voll.api.domain.address.AddressResponsePayload;

public record ClientUpdateResponsePayload(
		Long id,
		String name,
		String phone,
		AddressResponsePayload address
		) {

	public ClientUpdateResponsePayload(Client client) {
		this(client.getId(), client.getName(), client.getPhone(), new AddressResponsePayload(client.getAddress()));
	}

}
