package cembo.devs.ecommerce.business.concretes;

import cembo.devs.ecommerce.business.rules.ProductBusinessRules;
import cembo.devs.ecommerce.dataAccess.ProductRepository;
import cembo.devs.ecommerce.entities.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductManagerTest {

    @Mock
    private ProductRepository productRepository;

    private ProductManager productManager;
    private ProductBusinessRules productBusinessRules;

    @BeforeEach
    void setUp() {
        this.productBusinessRules = new ProductBusinessRules(productRepository);
        this.productManager = new ProductManager(this.productRepository, this.productBusinessRules);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void GivenProductWhenCreateShouldCreate() {
        // Given
        Product product = Product.builder()
                .name("Product 1")
                .price(100)
                .stock(10)
                .description("Description 1")
                .build();

        // When
        this.productManager.create(product);

        // Then
        assertEquals(product, this.productRepository.findByName(product.getName()));
    }
}