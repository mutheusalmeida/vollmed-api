package med.voll.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import med.voll.api.domain.user.User;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	private static final String ISSUER = "VollMed API";

	public String generateToken(User user) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
			
			return JWT.create()
					.withIssuer(ISSUER)
					.withSubject(user.getUsername())
					.withExpiresAt(expirationDate())
					.sign(algorithm);
		} catch (JWTCreationException e) {
			throw new RuntimeException("Error while generating token", e);
		}
	}
	
	public String getSubject(String JWToken) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
			
			return JWT.require(algorithm)
					.withIssuer(ISSUER)
					.build()
					.verify(JWToken)
					.getSubject();
		} catch (JWTVerificationException e) {
			throw new RuntimeException("Token invalid or has expired", e);
		}
	}

	private Instant expirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
