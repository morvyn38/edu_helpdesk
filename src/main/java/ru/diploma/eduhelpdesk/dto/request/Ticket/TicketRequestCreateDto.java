package ru.diploma.eduhelpdesk.dto.request.Ticket;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.diploma.eduhelpdesk.model.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestCreateDto {

    @NotBlank(message = "title не может быть пустым")
    @Size(min = 5, max=255, message = "title должен быть от 5 до 255 символов")
    private String title;

    @Size(max=65535, message = "title должен быть больше 65535 символов")
    @NotBlank(message = "description не может быть пустым")
    private String description;

    @NotNull(message = "authorId не должен быть пустым")
    @Positive(message = "authorId должен быть положительным")
    private Long authorId;

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
