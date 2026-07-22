package ma.emsi.portailagence.repository;

import ma.emsi.portailagence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}