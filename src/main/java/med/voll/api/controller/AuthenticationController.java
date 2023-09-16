package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.user.LoginUserRequestPayload;
import med.voll.api.domain.user.User;
import med.voll.api.infra.security.TokenService;
import med.voll.api.domain.user.LoginUserResponsePayload;

@RestController
@RequestMapping("login")
public class AuthenticationController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LoginUserResponsePayload> login(@RequestBody @Valid LoginUserRequestPayload req) {
		var token = new UsernamePasswordAuthenticationToken(req.username(), req.password());
		var authentication = authenticationManager.authenticate(token);
		var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
		
		return ResponseEntity.ok(new LoginUserResponsePayload(tokenJWT));
	}
}
