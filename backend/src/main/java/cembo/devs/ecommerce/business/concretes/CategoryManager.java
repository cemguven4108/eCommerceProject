package cembo.devs.ecommerce.business.concretes;

import cembo.devs.ecommerce.business.abstracts.CategoryService;
import cembo.devs.ecommerce.business.rules.CategoryBusinessRules;
import cembo.devs.ecommerce.dataAccess.CategoryRepository;
import cembo.devs.ecommerce.entities.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;


    @Override
    public void create(Category category) {
        log.atInfo().log("Running create method in CategoryManager");

        log.atInfo().log("Inserting category to database");
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        log.atInfo().log("Running delete method in CategoryManager");

        log.atInfo().log("Deleting category from database");
        this.categoryRepository.deleteById(id);
    }

    @Override
    public Category getById(int id) {
        log.atInfo().log("Running getById method in CategoryManager");

        log.atInfo().log("Getting category from database");
        Category category = this.categoryRepository.getById(id);

        log.atInfo().log("Returning category");
        return category;
    }

    @Override
    public List<Category> getAll() {
        log.atInfo().log("Running getAll method in CategoryManager");

        log.atInfo().log("Getting categories from database");
        List<Category> categories = this.categoryRepository.findAll();

        log.atInfo().log("Returning categories");
        return categories;
    }
}
