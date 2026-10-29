package ru.diploma.eduhelpdesk.dto.response.Status;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusResponseDto {
    private Long id;
    private String name;
    private String displayName;
    private Boolean isFinal;
}
