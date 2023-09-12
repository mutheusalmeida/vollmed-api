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
import med.voll.api.client.Client;
import med.voll.api.client.ClientListPayload;
import med.voll.api.client.ClientRegisterPayload;
import med.voll.api.client.ClientRepository;
import med.voll.api.client.ClientUpdatePayload;

@RestController
@RequestMapping("clients")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;

	@PostMapping
	@Transactional
	public void register(@RequestBody @Valid ClientRegisterPayload req) {
		clientRepository.save(new Client(req));
	}
	
	@GetMapping
	public Page<ClientListPayload> getClients(@PageableDefault(size = 10, sort = "name") Pageable pagination) {
		return clientRepository.findAllByActiveTrue(pagination);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public void update(@PathVariable Long id, @RequestBody @Valid ClientUpdatePayload req) {
		var client = clientRepository.getReferenceById(id);
		client.update(req);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void delete(@PathVariable Long id) {
		var client = clientRepository.getReferenceById(id);
		client.delete();
	}

}
