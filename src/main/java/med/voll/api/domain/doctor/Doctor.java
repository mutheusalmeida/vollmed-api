package med.voll.api.domain.doctor;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	private String crm;
	
	private Boolean active;
	
	@Enumerated(EnumType.STRING)
	private Specialty specialty;
	
	@Embedded
	private Address address;
	
	public Doctor(DoctorRequestPayload req) {
		this.name = req.name();
		this.email = req.email();
		this.phone = req.phone();
		this.crm = req.crm();
		this.active = true;
		this.specialty = req.specialty();
		this.address = new Address(req.address());
	}

	public void update(DoctorUpdateRequestPayload req) {
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
