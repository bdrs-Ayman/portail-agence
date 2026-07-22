package ma.emsi.portailagence.dto;
import ma.emsi.portailagence.entity.ProductType;
import lombok.Data;

@Data
public class ProductDTO {

    private Long id;

    private String nom;

    private String description;

    private ProductType type;

    private Double tauxInteret;

    private Double frais;

    private Boolean actif;
}