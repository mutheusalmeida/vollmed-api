package med.voll.api.domain.doctor;

import med.voll.api.domain.address.AddressResponsePayload;

public record DoctorResponsePayload(
		Long id,
		String name,
		String email,
		String phone,
		String crm,
		Specialty specialty,
		AddressResponsePayload address
		) {
	public DoctorResponsePayload (Doctor doctor) {
		this(
				doctor.getId(),
				doctor.getName(), 
				doctor.getEmail(), 
				doctor.getPhone(), 
				doctor.getCrm(), 
				doctor.getSpecialty(),
				new AddressResponsePayload(doctor.getAddress())
				);
	}
}
