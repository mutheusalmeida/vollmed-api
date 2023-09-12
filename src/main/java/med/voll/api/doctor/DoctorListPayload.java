package med.voll.api.doctor;

public record DoctorListPayload(
		Long id,
		String name,
		String email,
		String phone,
		String crm,
		Specialty specialty
		) {
	public DoctorListPayload (Doctor doctor) {
		this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getSpecialty());
	}
}
