package ru.diploma.eduhelpdesk.dto.request.Ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestUpdateDto {

    @NotBlank(message = "title не может быть пустым")
    @Size(min = 5, max=255, message = "title должен быть от 5 до 255 символов")
    private String title;

    @Size(max=65535, message = "title должен быть больше 65535 символов")
    @NotBlank(message = "description не может быть пустым")
    private String description;

    @NotNull(message = "assigneeId не должен быть пустым")
    @Positive(message = "assigneeId должен быть положительным")
    private Long assigneeId;

    @NotNull(message = "computerId не должен быть пустым")
    @Positive(message = "computerId должен быть положительным")
    private Long computerId;

    @NotNull(message = "categoryId не должен быть пустым")
    @Positive(message = "categoryId должен быть положительным")
    private Long categoryId;

    @NotNull(message = "priorityId не должен быть пустым")
    @Positive(message = "priorityId должен быть положительным")
    private Long priorityId;
}
