package ru.diploma.eduhelpdesk.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diploma.eduhelpdesk.dto.response.Status.StatusResponseDto;
import ru.diploma.eduhelpdesk.service.impl.StatusServiceImpl;

import java.util.List;

@Tag(name = "Status Management", description = "Операции со статусами")
@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    @Autowired
    private StatusServiceImpl statusService;

    @Operation(summary = "Получить все статусы")
    @GetMapping
    public List<StatusResponseDto> getAll() {
        return statusService.getAll();
    }
}

