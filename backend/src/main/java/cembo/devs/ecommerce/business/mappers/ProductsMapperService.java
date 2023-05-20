package cembo.devs.ecommerce.business.mappers;

import cembo.devs.ecommerce.business.responses.ProductGetResponse;
import cembo.devs.ecommerce.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductsMapperService {

    @Mapping(source = "product.subCategory", target = "subCategory")
    ProductGetResponse ProductToProductGetResponse(Product product);
}
