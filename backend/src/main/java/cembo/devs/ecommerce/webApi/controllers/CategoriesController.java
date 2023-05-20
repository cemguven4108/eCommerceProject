package cembo.devs.ecommerce.webApi.controllers;

import cembo.devs.ecommerce.business.abstracts.CategoryService;
import cembo.devs.ecommerce.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public void create(Category category) {
        this.categoryService.create(category);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.categoryService.delete(id);
    }

    @GetMapping("/get/{id}")
    public Category get(@PathVariable Long id) {
        return this.categoryService.getById(id);
    }

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return this.categoryService.getAll();
    }
}
