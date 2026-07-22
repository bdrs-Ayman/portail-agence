package ma.emsi.portailagence.repository;

import ma.emsi.portailagence.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    List<Subscription> findByClientId(Long clientId);

    boolean existsByClientIdAndProductIdAndStatus(Long clientId,
                                                  Long productId,
                                                  String status);
}