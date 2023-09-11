package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.client.Client;
import med.voll.api.client.ClientRegisterPayload;
import med.voll.api.client.ClientRepository;

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

}
