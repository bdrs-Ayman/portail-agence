package ma.emsi.portailagence.controller;

import ma.emsi.portailagence.repository.AccountRepository;
import ma.emsi.portailagence.repository.ClientRepository;
import ma.emsi.portailagence.repository.ProductRepository;
import ma.emsi.portailagence.repository.SubscriptionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DashboardController {

    private final ClientRepository clientRepository;
    private final AccountRepository accountRepository;
    private final ProductRepository productRepository;
    private final SubscriptionRepository subscriptionRepository;

    public DashboardController(
            ClientRepository clientRepository,
            AccountRepository accountRepository,
            ProductRepository productRepository,
            SubscriptionRepository subscriptionRepository) {

        this.clientRepository = clientRepository;
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @GetMapping("/api/dashboard/summary")
    public Map<String, Long> summary() {

        Map<String, Long> result = new HashMap<>();

        result.put("clients", clientRepository.count());
        result.put("accounts", accountRepository.count());
        result.put("products", productRepository.count());
        result.put("subscriptions", subscriptionRepository.count());

        return result;
    }
}