package ma.emsi.portailagence.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import ma.emsi.portailagence.entity.TypeCompte;

@Data
public class AccountDTO {

    private Long id;

    private String numeroCompte;

    private TypeCompte typeCompte;

    private LocalDate dateOuverture;

    private Double solde;

    private String statut;

    private Long clientId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}