package ru.diploma.eduhelpdesk.dto.request.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.diploma.eduhelpdesk.model.Category;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestCreateDto {
    private String name;
    private Category parentCategory;
}
