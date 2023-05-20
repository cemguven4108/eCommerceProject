package cembo.devs.ecommerce.business.abstracts;

import cembo.devs.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);
    void delete(Long id);
    Category getById(Long id);
    List<Category> getAll();
}
