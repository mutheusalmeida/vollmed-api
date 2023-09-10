package med.voll.api.doctor;

import med.voll.api.address.Address;

public record DoctorRegisterPayload(
		String name,
		String email,
		String phone,
		String crm,
		Specialty specialty,
		Address address
) {
	
}
