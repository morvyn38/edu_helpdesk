package ru.diploma.eduhelpdesk.dto.response.Ticket;

import lombok.*;
import ru.diploma.eduhelpdesk.dto.response.Category.CategoryResponseDto;
import ru.diploma.eduhelpdesk.dto.response.Computer.ComputerResponseDto;
import ru.diploma.eduhelpdesk.dto.response.Priority.PriorityResponseDto;
import ru.diploma.eduhelpdesk.dto.response.Status.StatusResponseDto;
import ru.diploma.eduhelpdesk.dto.response.User.UserResponseDto;
import ru.diploma.eduhelpdesk.model.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponseDto {
    private Long id;
    private String ticketNumber;
    private String title;
    private String description;

    private UserResponseDto author;
    private UserResponseDto assignee;
    private ComputerResponseDto computer;
    private CategoryResponseDto category;
    private PriorityResponseDto priority;
    private StatusResponseDto status;

//    private Boolean agentAttempted;
//    private Long agentTaskId;
    private LocalDateTime createdAt; // создана
    private LocalDateTime updatedAt; // обновлена
    private LocalDateTime resolvedAt; // решена
    private LocalDateTime closedAt; // закрыта
    private LocalDateTime dueAt; // дедлайн по SLA????
}
