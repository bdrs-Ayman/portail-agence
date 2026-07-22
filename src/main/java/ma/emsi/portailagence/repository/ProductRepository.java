package ma.emsi.portailagence.repository;

import ma.emsi.portailagence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActifTrue();

}