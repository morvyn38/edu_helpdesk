package ru.diploma.eduhelpdesk.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.diploma.eduhelpdesk.dto.response.Priority.PriorityResponseDto;
import ru.diploma.eduhelpdesk.service.PriorityService;
import java.util.List;

@Tag(name = "Priority Management", description = "Операции с приоритетами")
@RestController
@RequestMapping("/api/priorities")
public class PriorityController {

    @Autowired
    private PriorityService priorityService;

    @Operation(summary = "Получить все приоритеты")
    @GetMapping
    public List<PriorityResponseDto> getAll() {
        return priorityService.getAll();
    }
}
