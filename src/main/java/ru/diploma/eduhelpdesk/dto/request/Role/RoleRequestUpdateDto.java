package ru.diploma.eduhelpdesk.dto.request.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestUpdateDto {

    @NotBlank(message = "name не может быть пустым")
    @Size(min = 3, max = 255, message = "name должен быть от 3 до 255 символов")
    private String name;
}
