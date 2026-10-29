package ru.diploma.eduhelpdesk.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "ticket_number", nullable = false, unique = true)
    private String ticketNumber;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assignee_id")
    private User assignee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id", nullable = false)
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

//    @Column(name = "agent_attempted", nullable = false)
//    private Boolean agentAttempted;
//
//    @Column(name = "agent_task_id", nullable = false)
//    private Long agentTaskId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt; // создана

    @Column(name = "updated_id", nullable = false)
    private LocalDateTime updatedAt; // обновлена

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt; // решена

    @Column(name = "closed_at")
    private LocalDateTime closedAt; // закрыта

    @Column(name = "due_at", nullable = false)
    private LocalDateTime dueAt; // дедлайн по SLA????
}
