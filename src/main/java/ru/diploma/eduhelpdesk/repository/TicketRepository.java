package ru.diploma.eduhelpdesk.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.diploma.eduhelpdesk.model.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByTicketNumber(String ticketName);
    Optional<Ticket> findByAuthorId(Long id);
    Optional<Ticket> findByAssigneeId(Long id);
    Optional<Ticket> findByComputerId(Long id);
    Optional<Ticket> findByPriorityId(Long id);
    Optional<Ticket> findByStatusId(Long id);

    boolean existsByTicketNumber(String ticketNumber);

    @Query(value = "SELECT nextval('ticket_number_seq')", nativeQuery = true)
    Long getNextTicketSequence();
}
