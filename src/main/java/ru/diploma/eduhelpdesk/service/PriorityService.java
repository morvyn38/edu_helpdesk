package ru.diploma.eduhelpdesk.service;

import ru.diploma.eduhelpdesk.dto.response.Priority.PriorityResponseDto;
import ru.diploma.eduhelpdesk.model.Priority;

import java.util.List;

public interface PriorityService {
    List<PriorityResponseDto> getAll();

    Priority getEntityById(Long id);
    PriorityResponseDto toResponseDto(Priority priority);
}
