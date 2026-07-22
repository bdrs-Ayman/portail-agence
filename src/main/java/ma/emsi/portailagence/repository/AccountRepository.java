package ma.emsi.portailagence.repository;

import ma.emsi.portailagence.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByNumeroCompte(String numeroCompte);

}