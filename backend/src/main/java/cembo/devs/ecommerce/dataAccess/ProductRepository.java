package cembo.devs.ecommerce.dataAccess;

import cembo.devs.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product getById(int id);
    Product findByName(String name);
}
