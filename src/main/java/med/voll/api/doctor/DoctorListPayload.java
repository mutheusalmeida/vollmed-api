package med.voll.api.doctor;

public record DoctorListPayload(
		String name,
		String email,
		String phone,
		String crm,
		Specialty specialty
		) {
	public DoctorListPayload (Doctor doctor) {
		this(doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getSpecialty());
	}
}
