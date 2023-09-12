package med.voll.api.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Page<ClientListPayload> findAllByActiveTrue(Pageable pagination);

}
