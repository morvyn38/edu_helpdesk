package ru.diploma.eduhelpdesk.dto.response.User;

import lombok.*;
import ru.diploma.eduhelpdesk.model.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String role;
    private Boolean isActive;
}
