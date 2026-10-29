package ru.diploma.eduhelpdesk.dto.request.Status;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatusRequestCreateDto {
    private String name;
    private Boolean isFinal;
}
