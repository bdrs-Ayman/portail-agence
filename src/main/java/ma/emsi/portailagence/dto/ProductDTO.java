package ma.emsi.portailagence.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    private String nom;

    private String description;

    private String type;

    private Double tauxInteret;

    private Double frais;

    private Boolean actif;
}