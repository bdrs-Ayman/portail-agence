package ma.emsi.portailagence.service;

import ma.emsi.portailagence.dto.ClientDTO;
import ma.emsi.portailagence.entity.Client;
import ma.emsi.portailagence.mapper.ClientMapper;
import ma.emsi.portailagence.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClientDTO getClientById(Long id) {
        return ClientMapper.toDTO(
                clientRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Client not found"))
        );
    }

    public ClientDTO createClient(ClientDTO dto) {

        if (clientRepository.findByCin(dto.getCin()).isPresent()) {
            throw new RuntimeException("A client with this CIN already exists.");
        }

        Client client = ClientMapper.toEntity(dto);

        return ClientMapper.toDTO(clientRepository.save(client));
    }

    public ClientDTO updateClient(Long id, ClientDTO dto) {

        Client existing = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        existing.setNom(dto.getNom());
        existing.setPrenom(dto.getPrenom());
        existing.setCin(dto.getCin());
        existing.setDateNaissance(dto.getDateNaissance());
        existing.setTelephone(dto.getTelephone());
        existing.setEmail(dto.getEmail());
        existing.setAdresse(dto.getAdresse());
        existing.setVille(dto.getVille());
        existing.setProfession(dto.getProfession());
        existing.setStatut(dto.getStatut());

        return ClientMapper.toDTO(clientRepository.save(existing));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<ClientDTO> searchClients(String keyword) {
        return clientRepository
                .findByNomContainingIgnoreCaseOrPrenomContainingIgnoreCaseOrCinContainingIgnoreCaseOrTelephoneContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        keyword
                )
                .stream()
                .map(ClientMapper::toDTO)
                .collect(Collectors.toList());
    }
}