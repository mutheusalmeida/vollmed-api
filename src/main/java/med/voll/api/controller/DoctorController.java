package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.doctor.Doctor;
import med.voll.api.doctor.DoctorListPayload;
import med.voll.api.doctor.DoctorRegisterPayload;
import med.voll.api.doctor.DoctorRepository;

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
		return doctorRepository.findAll(pagination).map(DoctorListPayload::new);
	}

}
