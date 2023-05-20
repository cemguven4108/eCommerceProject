package cembo.devs.ecommerce.webApi.controllers;

import cembo.devs.ecommerce.business.abstracts.SubCategoryService;
import cembo.devs.ecommerce.entities.SubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/subCategories")
public class SubCategoriesController {

    private final SubCategoryService subCategoryService;

    @PostMapping("/create")
    public void create(SubCategory subCategory) {
        this.subCategoryService.create(subCategory);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        this.subCategoryService.delete(id);
    }

    @GetMapping("/get/{id}")
    public SubCategory get(@PathVariable int id) {
        return this.subCategoryService.getById(id);
    }

    @GetMapping("/getAll")
    public List<SubCategory> getAll() {
        return this.subCategoryService.getAll();
    }
}
