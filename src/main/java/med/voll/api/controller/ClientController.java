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
import med.voll.api.domain.client.Client;
import med.voll.api.domain.client.ClientListResponsePayload;
import med.voll.api.domain.client.ClientRepository;
import med.voll.api.domain.client.ClientRequestPayload;
import med.voll.api.domain.client.ClientResponsePayload;
import med.voll.api.domain.client.ClientUpdateRequestPayload;
import med.voll.api.domain.client.ClientUpdateResponsePayload;

@RestController
@RequestMapping("clients")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<ClientResponsePayload> register(@RequestBody @Valid ClientRequestPayload req, UriComponentsBuilder uriBuilder) {
		var client = clientRepository.save(new Client(req));
		
		var uri = uriBuilder.path("/clients/{id}").buildAndExpand(client.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new ClientResponsePayload(client));
	}
	
	@GetMapping
	public ResponseEntity<Page<ClientListResponsePayload>> getClients(@PageableDefault(size = 10, sort = "name") Pageable pagination) {
		var clients = clientRepository.findAllByActiveTrue(pagination);
		
		return ResponseEntity.ok(clients);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClientUpdateResponsePayload> update(@PathVariable Long id, @RequestBody @Valid ClientUpdateRequestPayload req) {
		var client = clientRepository.getReferenceById(id);
		client.update(req);
		
		return ResponseEntity.ok(new ClientUpdateResponsePayload(client));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientResponsePayload> getClient(@PathVariable Long id) {
		var client = clientRepository.getReferenceById(id);
		
		return ResponseEntity.ok(new ClientResponsePayload(client));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		var client = clientRepository.getReferenceById(id);
		client.delete();
		
		return ResponseEntity.noContent().build();
	}

}
