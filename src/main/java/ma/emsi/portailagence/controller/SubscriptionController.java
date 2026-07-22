package ma.emsi.portailagence.controller;

import ma.emsi.portailagence.dto.SubscriptionDTO;
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
    public SubscriptionDTO create(
            @RequestParam Long clientId,
            @RequestParam Long productId,
            @RequestParam(required = false) Long accountId,
            @RequestBody SubscriptionDTO dto) {

        return service.create(clientId, productId, accountId, dto);
    }

    @GetMapping("/client/{clientId}")
    public List<SubscriptionDTO> getClientSubscriptions(@PathVariable Long clientId) {
        return service.getByClient(clientId);
    }
    @PutMapping("/{id}/cancel")
    public SubscriptionDTO cancelSubscription(@PathVariable Long id) {
        return service.cancelSubscription(id);
    }
}