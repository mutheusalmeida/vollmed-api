package med.voll.api.domain.client;

public record ClientListResponsePayload(Long id, String name, String email, String phone) {
	
	public ClientListResponsePayload (Client client) {
		this(client.getId(), client.getName(), client.getEmail(), client.getPhone());
	}
	
}
