package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.domain.doctor.Doctor;
import med.voll.api.domain.doctor.DoctorListResponsePayload;
import med.voll.api.domain.doctor.DoctorRepository;
import med.voll.api.domain.doctor.DoctorRequestPayload;
import med.voll.api.domain.doctor.DoctorResponsePayload;
import med.voll.api.domain.doctor.DoctorUpdateRequestPayload;

@RestController
@RequestMapping("doctors")
public class DoctorController {
	
	@Autowired
	private DoctorRepository doctorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<DoctorResponsePayload> register(@RequestBody @Valid DoctorRequestPayload req, UriComponentsBuilder uriBuilder) {
		var doctor = doctorRepository.save(new Doctor(req));
		
		var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
				
		return ResponseEntity.created(uri).body(new DoctorResponsePayload(doctor));
	}
	
	@GetMapping
	public ResponseEntity<Page<DoctorListResponsePayload>> getDoctors(@PageableDefault(size = 10, sort = "name") Pageable pagination) {
		var doctors = doctorRepository.findAllByActiveTrue(pagination);
		
		return ResponseEntity.ok(doctors);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DoctorResponsePayload> update(@PathVariable Long id, @RequestBody @Valid DoctorUpdateRequestPayload req) {
		var doctor = doctorRepository.getReferenceById(id);
		doctor.update(req);
		
		return ResponseEntity.ok(new DoctorResponsePayload(doctor));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DoctorResponsePayload> getDoctor(@PathVariable Long id) {
		var client = doctorRepository.getReferenceById(id);
		
		return ResponseEntity.ok(new DoctorResponsePayload(client));
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		var doctor =  doctorRepository.getReferenceById(id);
		doctor.delete();
		
		return ResponseEntity.noContent().build();
	}

}
