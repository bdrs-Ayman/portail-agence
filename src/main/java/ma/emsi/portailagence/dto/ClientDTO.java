package ma.emsi.portailagence.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClientDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String cin;

    private LocalDate dateNaissance;

    private String telephone;

    private String email;

    private String adresse;

    private String ville;

    private String profession;

    private String statut;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}