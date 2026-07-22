package ma.emsi.portailagence.controller;

import ma.emsi.portailagence.entity.Subscription;
import ma.emsi.portailagence.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionService service;

    public SubscriptionController(SubscriptionService service) {
        this.service = service;
    }

    @PostMapping
    public Subscription create(
            @RequestParam Long clientId,
            @RequestParam Long productId,
            @RequestParam(required = false) Long accountId,
            @RequestBody Subscription subscription) {

        return service.create(clientId, productId, accountId, subscription);
    }

    @GetMapping("/client/{clientId}")
    public List<Subscription> getClientSubscriptions(@PathVariable Long clientId) {
        return service.getByClient(clientId);
    }
}