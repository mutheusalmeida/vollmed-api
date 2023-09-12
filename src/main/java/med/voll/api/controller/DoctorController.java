package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorListPayload;
import med.voll.api.doctor.DoctorRegisterPayload;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.DoctorUpdatePayload;

@RestController
@RequestMapping("doctors")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@PostMapping
	@Transactional
	public void register(@RequestBody @Valid DoctorRegisterPayload req) {
		doctorRepository.save(new Doctor(req));
	}
	
	@GetMapping
	public Page<DoctorListPayload> getDoctors (@PageableDefault(size = 10, sort = "name") Pageable pagination) {
		return doctorRepository.findAllByActiveTrue(pagination);
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody @Valid DoctorUpdatePayload req) {
		var doctor = doctorRepository.getReferenceById(req.id());
		doctor.update(req);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		var doctor =  doctorRepository.getReferenceById(id);
		doctor.delete();
	}

}
