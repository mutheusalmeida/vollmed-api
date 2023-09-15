package med.voll.api.domain.doctor;

public record DoctorListResponsePayload(
		Long id,
		String name,
		String email,
		String phone,
		String crm,
		Specialty specialty
		) {
	public DoctorListResponsePayload (Doctor doctor) {
		this(
				doctor.getId(),
				doctor.getName(), 
				doctor.getEmail(), 
				doctor.getPhone(), 
				doctor.getCrm(), 
				doctor.getSpecialty()
				);
	}
}
