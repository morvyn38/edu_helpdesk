package ru.diploma.eduhelpdesk.dto.response.Priority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriorityResponseDto {
    private Long id;
    private String name;
    private String displayName;
    private Integer level;
}
