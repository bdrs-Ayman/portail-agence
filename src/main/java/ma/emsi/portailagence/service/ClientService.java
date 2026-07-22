package ma.emsi.portailagence.service;

import ma.emsi.portailagence.entity.Client;
import ma.emsi.portailagence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client createClient(Client client) {

        if (clientRepository.findByCin(client.getCin()).isPresent()) {
            throw new RuntimeException("A client with this CIN already exists.");
        }

        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {

        Client existing = getClientById(id);

        existing.setNom(client.getNom());
        existing.setPrenom(client.getPrenom());
        existing.setCin(client.getCin());
        existing.setDateNaissance(client.getDateNaissance());
        existing.setTelephone(client.getTelephone());
        existing.setEmail(client.getEmail());
        existing.setAdresse(client.getAdresse());
        existing.setVille(client.getVille());
        existing.setProfession(client.getProfession());
        existing.setStatut(client.getStatut());

        return clientRepository.save(existing);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}