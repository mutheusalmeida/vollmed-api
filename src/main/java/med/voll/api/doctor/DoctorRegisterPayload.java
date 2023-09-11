package med.voll.api.doctor;

import med.voll.api.address.AddressRegisterPayload;

public record DoctorRegisterPayload(
		String name,
		String email,
		String phone,
		String crm,
		Specialty specialty,
		AddressRegisterPayload address
) {
	
}
