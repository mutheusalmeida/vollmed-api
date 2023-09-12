package med.voll.api.client;

public record ClientListPayload(String name, String email, String phone) {
	
	public ClientListPayload (Client client) {
		this(client.getName(), client.getEmail(), client.getPhone());
	}
	
}
