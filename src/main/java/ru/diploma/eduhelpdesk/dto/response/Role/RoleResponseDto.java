package ru.diploma.eduhelpdesk.dto.response.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseDto {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
}
