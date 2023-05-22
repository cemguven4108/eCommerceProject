package cembo.devs.ecommerce.business.abstracts;

import cembo.devs.ecommerce.business.responses.ProductGetResponse;
import cembo.devs.ecommerce.entities.Product;

import java.util.List;

public interface ProductService {
    void create(Product product);
    void delete(int id);
    ProductGetResponse getById(int id);
    List<ProductGetResponse> getAll();
}
