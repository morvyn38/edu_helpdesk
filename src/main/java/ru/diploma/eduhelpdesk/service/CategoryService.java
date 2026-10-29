package ru.diploma.eduhelpdesk.service;

import ru.diploma.eduhelpdesk.dto.request.Category.CategoryRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.response.Category.CategoryResponseDto;
import ru.diploma.eduhelpdesk.model.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto create(CategoryRequestCreateDto dto);
    List<CategoryResponseDto> getAll();
    Category getEntityById(Long id);
}
