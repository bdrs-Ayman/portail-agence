package ma.emsi.portailagence.mapper;

import ma.emsi.portailagence.dto.ClientDTO;
import ma.emsi.portailagence.entity.Client;

public class ClientMapper {

    public static ClientDTO toDTO(Client client) {

        if (client == null) {
            return null;
        }

        ClientDTO dto = new ClientDTO();

        dto.setId(client.getId());
        dto.setNom(client.getNom());
        dto.setPrenom(client.getPrenom());
        dto.setCin(client.getCin());
        dto.setDateNaissance(client.getDateNaissance());
        dto.setTelephone(client.getTelephone());
        dto.setEmail(client.getEmail());
        dto.setAdresse(client.getAdresse());
        dto.setVille(client.getVille());
        dto.setProfession(client.getProfession());
        dto.setStatut(client.getStatut());
        dto.setCreatedAt(client.getCreatedAt());
        dto.setUpdatedAt(client.getUpdatedAt());

        return dto;
    }

    public static Client toEntity(ClientDTO dto) {

        if (dto == null) {
            return null;
        }

        Client client = new Client();

        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setCin(dto.getCin());
        client.setDateNaissance(dto.getDateNaissance());
        client.setTelephone(dto.getTelephone());
        client.setEmail(dto.getEmail());
        client.setAdresse(dto.getAdresse());
        client.setVille(dto.getVille());
        client.setProfession(dto.getProfession());
        client.setStatut(dto.getStatut());

        return client;
    }
}