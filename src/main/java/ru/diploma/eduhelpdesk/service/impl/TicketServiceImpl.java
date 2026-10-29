package ru.diploma.eduhelpdesk.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diploma.eduhelpdesk.dto.request.Ticket.TicketRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Ticket.TicketRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Ticket.TicketResponseDto;
import ru.diploma.eduhelpdesk.enums.CategoryMainEnum;
import ru.diploma.eduhelpdesk.enums.CategorySubEnum;
import ru.diploma.eduhelpdesk.enums.StatusEnum;
import ru.diploma.eduhelpdesk.model.Category;
import ru.diploma.eduhelpdesk.model.Status;
import ru.diploma.eduhelpdesk.model.Ticket;
import ru.diploma.eduhelpdesk.repository.*;
import ru.diploma.eduhelpdesk.service.*;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ComputerServiceImpl computerService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private PriorityServiceImpl priorityService;

    @Autowired
    private StatusServiceImpl statusService;


    @Override
    @Transactional
    public TicketResponseDto create(TicketRequestCreateDto dto) {
        Category category = categoryService.getEntityById(dto.getCategoryId());

        String categoryPrefix = CategorySubEnum.fromName(category.getName()).getParent().getTicketNumberPrefix();
        Long nextSequence = ticketRepository.getNextTicketSequence();

        String generatedNumber = String.format("%s-N-%07d", categoryPrefix, nextSequence);

        Status status = statusService.getEntityByName(StatusEnum.NEW.getDbName());

        Ticket ticket = new Ticket();

        ticket.setTitle(dto.getTitle());
        ticket.setDescription(dto.getDescription());
        ticket.setAuthor(userService.getEntityById(dto.getAuthorId()));
        ticket.setAssignee(null);
        ticket.setTicketNumber(generatedNumber);
        ticket.setComputer(computerService.getEntityById(dto.getComputerId()));
        ticket.setPriority(priorityService.getEntityById(dto.getPriorityId()));
        ticket.setCategory(category);
        ticket.setStatus(status);
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setUpdatedAt(LocalDateTime.now());
        ticket.setResolvedAt(null);
        ticket.setClosedAt(null);
        ticket.setDueAt(LocalDateTime.now());

        return toResponseDto(ticketRepository.save(ticket));
    }

    @Override
    @Transactional
    public TicketResponseDto update(Long id, TicketRequestUpdateDto ticket) {
        Ticket existTicket = ticketRepository.findById(id).orElseThrow();

        existTicket.setTitle(ticket.getTitle());
        existTicket.setDescription(ticket.getDescription());
        existTicket.setAssignee(userService.getEntityById(ticket.getAssigneeId()));
        existTicket.setComputer(computerService.getEntityById(ticket.getComputerId()));
        existTicket.setCategory(categoryService.getEntityById(ticket.getCategoryId()));
        existTicket.setPriority(priorityService.getEntityById(ticket.getPriorityId()));

        return toResponseDto(ticketRepository.save(existTicket));
    }

    @Override
    @Transactional
    public TicketResponseDto getById(Long id) {
        return toResponseDto(ticketRepository.findById(id).orElseThrow());
    }

    @Override
    @Transactional
    public List<TicketResponseDto> getAll() {
        return ticketRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        ticketRepository.deleteById(id);
    }

    private TicketResponseDto toResponseDto(Ticket ticket) {
        return new TicketResponseDto(
                ticket.getId(),
                ticket.getTicketNumber(),
                ticket.getTitle(),
                ticket.getDescription(),

                userService.toResponseDto(ticket.getAuthor()),
                ticket.getAssignee() != null ? userService.toResponseDto(ticket.getAssignee()) : null,
                computerService.toResponseDto(ticket.getComputer()),
                categoryService.toResponseDto(ticket.getCategory()),
                priorityService.toResponseDto(ticket.getPriority()),
                statusService.toResponseDto(ticket.getStatus()),

//                ticket.getAgentAttempted(),
//                ticket.getAgentTaskId(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt(),
                ticket.getResolvedAt(),
                ticket.getClosedAt(),
                ticket.getDueAt()
        );
    }
}
