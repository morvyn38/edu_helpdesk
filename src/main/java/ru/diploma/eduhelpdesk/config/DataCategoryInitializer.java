package ru.diploma.eduhelpdesk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.diploma.eduhelpdesk.dto.request.Category.CategoryRequestCreateDto;
import ru.diploma.eduhelpdesk.enums.CategoryMainEnum;
import ru.diploma.eduhelpdesk.enums.CategorySubEnum;
import ru.diploma.eduhelpdesk.model.Category;
import ru.diploma.eduhelpdesk.repository.CategoryRepository;
import ru.diploma.eduhelpdesk.service.CategoryService;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DataCategoryInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() > 0) {
            return;
        }

        Map<CategoryMainEnum, Category> mainMap = new HashMap<>();

        for (CategoryMainEnum categoryMainEnum : CategoryMainEnum.values()) {
            Category category = new Category();

            category.setName(categoryMainEnum.getName());
            category.setParentCategory(null);

            mainMap.put(categoryMainEnum, categoryRepository.save(category));
        }
        System.out.println("Все ОСНОВНЫЕ КАТЕГОРИИ проинициализированы!");

        for (CategorySubEnum categorySubEnum : CategorySubEnum.values()) {
            Category category = new Category();

            category.setName(categorySubEnum.getName());
            category.setParentCategory(mainMap.get(categorySubEnum.getParent()));

            categoryRepository.save(category);
        }
        System.out.println("Все ПОДКАТЕГОРИИ проинициализированы!");
    }
}
