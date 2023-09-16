package med.voll.api.domain.user;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {

	public String generateToken(User user) {
		try {
			var algorithm = Algorithm.HMAC256("12345678");
			
			return JWT
					.create()
					.withIssuer("VollMed API")
					.withSubject(user.getUsername())
					.withExpiresAt(expirationDate())
					.sign(algorithm);
		} catch (JWTCreationException e) {
			throw new RuntimeException("Error while generating token.", e);
		}
	}

	private Instant expirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}
