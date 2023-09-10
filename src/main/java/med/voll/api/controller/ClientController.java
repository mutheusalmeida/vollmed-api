package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.client.ClientRegisterPayload;

@RestController
@RequestMapping("clients")
public class ClientController {

	@PostMapping
	public void register(@RequestBody ClientRegisterPayload req) {
		System.out.println(req);
	}

}
