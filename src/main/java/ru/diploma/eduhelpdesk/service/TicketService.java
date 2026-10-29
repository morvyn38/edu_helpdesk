package ru.diploma.eduhelpdesk.service;

import ru.diploma.eduhelpdesk.dto.request.Ticket.TicketRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Ticket.TicketRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Ticket.TicketResponseDto;

import java.util.List;

public interface TicketService {
    TicketResponseDto create(TicketRequestCreateDto ticket);
    TicketResponseDto update(Long id, TicketRequestUpdateDto ticket);
    TicketResponseDto getById(Long id);
    List<TicketResponseDto> getAll();
    void delete(Long id);
}
