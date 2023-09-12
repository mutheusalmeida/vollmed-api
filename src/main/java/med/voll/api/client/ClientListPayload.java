package med.voll.api.client;

public record ClientListPayload(Long id, String name, String email, String phone) {
	
	public ClientListPayload (Client client) {
		this(client.getId(), client.getName(), client.getEmail(), client.getPhone());
	}
	
}
