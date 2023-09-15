package med.voll.api.domain.doctor;

import med.voll.api.domain.address.AddressResponsePayload;

public record DoctorUpdateResponsePayload(
		String name,
		String phone,
		AddressResponsePayload address
		) {
	public DoctorUpdateResponsePayload(Doctor doctor) {
		this(doctor.getName(), doctor.getPhone(), new AddressResponsePayload(doctor.getAddress()));
	}
}
