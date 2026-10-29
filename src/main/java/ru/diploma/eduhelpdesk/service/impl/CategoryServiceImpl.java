package ru.diploma.eduhelpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diploma.eduhelpdesk.dto.request.Category.CategoryRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.response.Category.CategoryResponseDto;
import ru.diploma.eduhelpdesk.enums.CategoryMainEnum;
import ru.diploma.eduhelpdesk.enums.CategorySubEnum;
import ru.diploma.eduhelpdesk.model.Category;
import ru.diploma.eduhelpdesk.repository.CategoryRepository;
import ru.diploma.eduhelpdesk.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDto create(CategoryRequestCreateDto dto) {
        Category category = new Category();

        category.setName(dto.getName());
        category.setParentCategory(dto.getParentCategory());

        return toResponseDto(categoryRepository.save(category));
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public Category getEntityById(Long id) {
        return categoryRepository.findById(id).orElseThrow();
    }


    // TODO Убрать колхоз Category to responseDTO!!!
    public CategoryResponseDto toResponseDto(Category category) {
        String displayName;
        Long parentId = null; // По умолчанию null, если это главная категория

        if (category.getParentCategory() != null) {
            displayName = CategorySubEnum.fromName(category.getName()).getDisplayName();

            // ВАЖНО: вызываем getId() прямо здесь, пока сессия жива!
            parentId = category.getParentCategory().getId();
        } else {
            displayName = CategoryMainEnum.fromName(category.getName()).getDisplayName();
        }

        return new CategoryResponseDto(
                category.getId(),
                category.getName(),
                displayName,
                parentId // Передаем просто число
        );
    }
}
