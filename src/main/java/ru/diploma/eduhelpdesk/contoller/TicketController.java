package ru.diploma.eduhelpdesk.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.diploma.eduhelpdesk.dto.request.Ticket.TicketRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Ticket.TicketRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Ticket.TicketResponseDto;
import ru.diploma.eduhelpdesk.service.impl.TicketServiceImpl;

import java.util.List;

@Tag(name = "Tickets Management", description = "Операции с тикетами")
@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketServiceImpl ticketService;

    @Operation(summary = "Получения тикета по ID")
    @GetMapping("/{id}")
    public TicketResponseDto getById(@PathVariable Long id) {
        return ticketService.getById(id);
    }

    @Operation(summary = "Получение всех тикетов")
    @GetMapping
    public List<TicketResponseDto> getAll() {
        return ticketService.getAll();
    }

    @Operation(summary = "Создание тикета")
    @PostMapping
    public TicketResponseDto create(@RequestBody TicketRequestCreateDto ticket) {
        return ticketService.create(ticket);
    }

    @Operation(summary = "Обновление тикета по ID")
    @PutMapping("/{id}")
    public TicketResponseDto update(@PathVariable Long id, @RequestBody TicketRequestUpdateDto ticket) {
        return ticketService.update(id, ticket);
    }

    @Operation(summary = "Удаление тикета по ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ticketService.delete(id);
    }

}
