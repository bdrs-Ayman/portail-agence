package ma.emsi.portailagence.service;

import ma.emsi.portailagence.entity.*;
import ma.emsi.portailagence.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;

    public SubscriptionService(
            SubscriptionRepository subscriptionRepository,
            ClientRepository clientRepository,
            ProductRepository productRepository,
            AccountRepository accountRepository) {

        this.subscriptionRepository = subscriptionRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
    }

    public Subscription create(Long clientId,
                               Long productId,
                               Long accountId,
                               Subscription subscription) {

        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        subscription.setClient(client);
        subscription.setProduct(product);

        if (accountId != null) {
            Account account = accountRepository.findById(accountId)
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            subscription.setAccount(account);
        }

        subscription.setSubscriptionDate(LocalDate.now());

        if (subscription.getStatus() == null) {
            subscription.setStatus("ACTIVE");
        }

        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getByClient(Long clientId) {
        return subscriptionRepository.findByClientId(clientId);
    }
}