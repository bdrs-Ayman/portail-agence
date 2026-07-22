package ma.emsi.portailagence.controller;

import ma.emsi.portailagence.dto.ClientDTO;
import ma.emsi.portailagence.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public ClientDTO createClient(@RequestBody ClientDTO client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public ClientDTO updateClient(@PathVariable Long id,
                                  @RequestBody ClientDTO client) {
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/search")
    public List<ClientDTO> searchClients(@RequestParam String keyword) {
        return clientService.searchClients(keyword);
    }
}