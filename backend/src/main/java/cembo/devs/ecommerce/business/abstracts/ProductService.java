package cembo.devs.ecommerce.business.abstracts;

import cembo.devs.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);
    void delete(int id);
    Product getById(int id);
    List<Product> getAll();
}
