package ru.diploma.eduhelpdesk.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "content")
    private String content;

    @Column(name = "is_internal")
    private Boolean isInternal;

    @Column(name = "is_agent")
    private Boolean isAgent;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
