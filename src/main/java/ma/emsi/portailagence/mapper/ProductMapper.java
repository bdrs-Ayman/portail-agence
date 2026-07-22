package ma.emsi.portailagence.mapper;

import ma.emsi.portailagence.dto.ProductDTO;
import ma.emsi.portailagence.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {

        if (product == null) {
            return null;
        }

        ProductDTO dto = new ProductDTO();

        dto.setId(product.getId());
        dto.setNom(product.getNom());
        dto.setDescription(product.getDescription());
        dto.setType(product.getType());
        dto.setTauxInteret(product.getTauxInteret());
        dto.setFrais(product.getFrais());
        dto.setActif(product.isActif());

        return dto;
    }

    public static Product toEntity(ProductDTO dto) {

        if (dto == null) {
            return null;
        }

        Product product = new Product();

        product.setNom(dto.getNom());
        product.setDescription(dto.getDescription());
        product.setType(dto.getType());
        product.setTauxInteret(dto.getTauxInteret());
        product.setFrais(dto.getFrais());
        product.setActif(dto.getActif());

        return product;
    }
}