package cembo.devs.ecommerce.business.concretes;

import cembo.devs.ecommerce.business.abstracts.SubCategoryService;
import cembo.devs.ecommerce.business.rules.SubCategoryBusinessRules;
import cembo.devs.ecommerce.dataAccess.SubCategoryRepository;
import cembo.devs.ecommerce.entities.SubCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SubCategoryManager implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryBusinessRules subCategoryBusinessRules;

    @Override
    public void create(SubCategory subCategory) {
        log.atInfo().log("Running create method in SubCategoryManager");

        log.atInfo().log("Inserting subCategory to database");
        this.subCategoryRepository.save(subCategory);
    }

    @Override
    public void delete(int id) {
        log.atInfo().log("Running delete method in SubCategoryManager");

        log.atInfo().log("Deleting subCategory from database");
        this.subCategoryRepository.deleteById(id);
    }

    @Override
    public SubCategory getById(int id) {
        log.atInfo().log("Running getById method in SubCategoryManager");

        log.atInfo().log("Getting subCategory from database");
        SubCategory subCategory = this.subCategoryRepository.getById(id);

        log.atInfo().log("Returning subCategory");
        return subCategory;
    }

    @Override
    public List<SubCategory> getAll() {
        log.atInfo().log("Running getAll method in SubCategoryManager");

        log.atInfo().log("Getting subCategories from database");
        List<SubCategory> subCategories = this.subCategoryRepository.findAll();

        log.atInfo().log("Returning subCategories");
        return subCategories;
    }
}
