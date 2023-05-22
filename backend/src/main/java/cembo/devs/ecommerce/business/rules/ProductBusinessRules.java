package cembo.devs.ecommerce.business.rules;

import cembo.devs.ecommerce.core.utilities.exceptions.runtimeExceptions.ProductNotFoundException;
import cembo.devs.ecommerce.dataAccess.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j // lombok
@Service
@RequiredArgsConstructor
public class ProductBusinessRules {

    private final ProductRepository productRepository;

    public void checkIfProductExists(int id) {
        log.atInfo().log("Checking if product exists");

        if (this.productRepository.findById(id).isEmpty())
            throw new ProductNotFoundException("Product with id " + id + " does not exist");
    }
}
