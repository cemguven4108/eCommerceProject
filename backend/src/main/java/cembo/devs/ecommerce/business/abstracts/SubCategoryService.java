package cembo.devs.ecommerce.business.abstracts;

import cembo.devs.ecommerce.entities.SubCategory;

import java.util.List;

public interface SubCategoryService {
    void create(SubCategory subCategory);
    void delete(Long id);
    SubCategory getById(Long id);
    List<SubCategory> getAll();
}
