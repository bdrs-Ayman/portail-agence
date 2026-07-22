package ma.emsi.portailagence.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AccountDTO {

    private Long id;

    private String numeroCompte;

    private String typeCompte;

    private LocalDate dateOuverture;

    private Double solde;

    private String statut;

    private Long clientId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}