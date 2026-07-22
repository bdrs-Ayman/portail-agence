package ma.emsi.portailagence.repository;

import ma.emsi.portailagence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCin(String cin);

    List<Client> findByNomContainingIgnoreCase(String nom);

    List<Client> findByTelephoneContaining(String telephone);
}