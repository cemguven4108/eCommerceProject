package cembo.devs.ecommerce.webApi.controllers;

import cembo.devs.ecommerce.business.abstracts.ProductService;
import cembo.devs.ecommerce.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/products")
public class ProductsController {

    private final ProductService productService;

    @PostMapping(value = "/create")
    public void create(Product product) {
        this.productService.create(product);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable int id) {
        this.productService.delete(id);
    }

    @GetMapping(value = "/get/{id}")
    public Product getById(@PathVariable int id) {
        return this.productService.getById(id);
    }

    @GetMapping(value = "/getAll")
    public List<Product> getAll() {
        return this.productService.getAll();
    }
}
