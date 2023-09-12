package med.voll.api.client;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

@Table(name = "clients")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String cpf;
	
	private Boolean active;
	
	@Embedded
	private Address address;
	
	public Client(ClientRegisterPayload req) {
		this.name = req.name();
		this.email = req.email();
		this.phone = req.phone();
		this.cpf = req.cpf();
		this.active = true;
		this.address = new Address(req.address());
	}

	public void update(ClientUpdatePayload req) {
		if (req.name() != null) {
			this.name = req.name();
		}
		
		if (req.phone() != null) {
			this.phone = req.phone();
		}
		
		if (req.address() != null) {
			this.address.update(req.address());
		}
		
	}

	public void delete() {
		this.active = false;
	}
}
