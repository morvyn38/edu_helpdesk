package ru.diploma.eduhelpdesk.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diploma.eduhelpdesk.dto.response.Category.CategoryResponseDto;
import ru.diploma.eduhelpdesk.service.impl.CategoryServiceImpl;

import java.util.List;

@Tag(name = "Category Management", description = "Операции с категориями")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Operation(summary = "Получить все категории")
    @GetMapping
    public List<CategoryResponseDto> getAll() {
        return categoryService.getAll();
    }
}
