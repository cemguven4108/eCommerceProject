package cembo.devs.ecommerce.business.concretes;

import cembo.devs.ecommerce.business.abstracts.ProductService;
import cembo.devs.ecommerce.business.rules.ProductBusinessRules;
import cembo.devs.ecommerce.dataAccess.ProductRepository;
import cembo.devs.ecommerce.entities.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j // lombok
@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final ProductBusinessRules productBusinessRules;

    @Override
    public void create(Product product) {
        log.atInfo().log("Running create method in ProductManager");

        this.productBusinessRules.checkIfProductStocksAreFull(product.getStock());

        log.atInfo().log("Inserting product to database");
        this.productRepository.save(product);

        log.atInfo().log("Completed create method in ProductManager");
    }

    @Override
    public void delete(int id) {
        log.atInfo().log("Running delete method in ProductManager");

        this.productBusinessRules.checkIfProductExists(id);

        log.atInfo().log("Deleting product from database");
        this.productRepository.deleteById(id);

        log.atInfo().log("Completed delete method in ProductManager");
    }

    @Override
    public Product getById(int id) {
        log.atInfo().log("Running getById method in ProductManager");

        this.productBusinessRules.checkIfProductExists(id);

        log.atInfo().log("Getting product from database");
        Product product = this.productRepository.getById(id);

        log.atInfo().log("Returning product");
        return product;
    }

    @Override
    public List<Product> getAll() {
        log.atInfo().log("Running getAll method in ProductManager");

        log.atInfo().log("Getting all products from database");
        List<Product> products =this.productRepository.findAll();

        log.atInfo().log("Returning all products");
        return products;
    }
}
