package cembo.devs.ecommerce.business.abstracts;

import cembo.devs.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {
    void create(Category category);
    void delete(int id);
    Category getById(int id);
    List<Category> getAll();
}
