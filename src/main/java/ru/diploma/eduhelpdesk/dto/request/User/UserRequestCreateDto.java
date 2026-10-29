package ru.diploma.eduhelpdesk.dto.request.User;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestCreateDto {

    @NotBlank(message = "Username не может быть пустым")
    @Size(min = 5, max = 50, message = "username должен быть от 5 до 50 символов")
    private String username;

    @NotBlank(message = "ФИО не может быть пустым")
    @Size(max = 150, message = "fullName слишком длинный")
    private String fullName;

    @NotBlank(message = "email не может быть пустым")
    @Email(message = "email имеет неверный формат")
    private String email;

    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 6, max = 100, message = "password должен быть от 6 до 100 символов")
    private String password;

    @NotNull(message = "roleId обязателен")
    @Positive(message = "roleId должен быть положительным")
    private Long roleId;

    private Boolean isActive;
}
