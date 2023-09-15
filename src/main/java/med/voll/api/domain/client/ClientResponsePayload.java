package med.voll.api.domain.client;

import med.voll.api.domain.address.AddressResponsePayload;

public record ClientResponsePayload(
		Long id,
		String name,
		String email,
		String cpf,
		String phone,
		AddressResponsePayload address
		) {
	public ClientResponsePayload(Client client) {
		this(
				client.getId(),
				client.getName(),
				client.getEmail(),
				client.getCpf(),
				client.getPhone(),
				new AddressResponsePayload(client.getAddress())
				);
	}
}
