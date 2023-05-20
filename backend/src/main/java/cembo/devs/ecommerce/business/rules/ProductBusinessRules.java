package cembo.devs.ecommerce.business.rules;

import cembo.devs.ecommerce.core.utilities.exceptions.ProductNotFoundException;
import cembo.devs.ecommerce.core.utilities.exceptions.StockLimitExceededException;
import cembo.devs.ecommerce.dataAccess.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j // lombok
@Service
@RequiredArgsConstructor
public class ProductBusinessRules {

    private final int PRODUCT_STOCK_LIMIT = 50;

    private final ProductRepository productRepository;

    public void checkIfProductStocksAreFull(int stock) {
        log.atInfo().log("Checking if product stocks are full");

        if (stock >= PRODUCT_STOCK_LIMIT) {
            throw new StockLimitExceededException("Product stocks cannot be more than " + PRODUCT_STOCK_LIMIT);
        }
    }

    public void checkIfProductExists(int id) {
        log.atInfo().log("Checking if product exists");

        if (this.productRepository.findById(id).isEmpty())
            throw new ProductNotFoundException("Product with id " + id + " does not exist");
    }
}
