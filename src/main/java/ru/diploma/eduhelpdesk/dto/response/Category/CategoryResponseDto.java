package ru.diploma.eduhelpdesk.dto.response.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.diploma.eduhelpdesk.model.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String displayName;
    private Long parentId;
}
