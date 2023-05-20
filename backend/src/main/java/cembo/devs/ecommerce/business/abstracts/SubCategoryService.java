package cembo.devs.ecommerce.business.abstracts;

import cembo.devs.ecommerce.entities.SubCategory;

import java.util.List;

public interface SubCategoryService {
    void create(SubCategory subCategory);
    void delete(int id);
    SubCategory getById(int id);
    List<SubCategory> getAll();
}
