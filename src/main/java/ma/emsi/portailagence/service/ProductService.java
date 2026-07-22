package ma.emsi.portailagence.service;

import ma.emsi.portailagence.dto.ProductDTO;
import ma.emsi.portailagence.entity.Product;
import ma.emsi.portailagence.mapper.ProductMapper;
import ma.emsi.portailagence.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDTO> getAllProducts() {
        return repository.findAll()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getById(Long id) {
        return ProductMapper.toDTO(
                repository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Product not found"))
        );
    }

    public ProductDTO create(ProductDTO dto) {

        Product product = ProductMapper.toEntity(dto);

        return ProductMapper.toDTO(repository.save(product));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}