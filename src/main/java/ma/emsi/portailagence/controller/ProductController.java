package ma.emsi.portailagence.controller;

import ma.emsi.portailagence.dto.ProductDTO;
import ma.emsi.portailagence.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductDTO> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO product) {
        return service.create(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
    @GetMapping("/active")
    public List<ProductDTO> getActiveProducts() {
        return service.getActiveProducts();
    }
    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id,
                             @RequestBody ProductDTO dto) {

        return service.update(id, dto);
    }
}