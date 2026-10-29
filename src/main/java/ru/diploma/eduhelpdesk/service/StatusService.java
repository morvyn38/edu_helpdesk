package ru.diploma.eduhelpdesk.service;

import ru.diploma.eduhelpdesk.dto.request.Status.StatusRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Status.StatusRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Status.StatusResponseDto;
import ru.diploma.eduhelpdesk.model.Status;

import java.util.List;

public interface StatusService {
    StatusResponseDto create(StatusRequestCreateDto dto);
    StatusResponseDto getById(Long id);
    StatusResponseDto getByName(String name);
    List<StatusResponseDto> getAll();

    StatusResponseDto update(Long id, StatusRequestUpdateDto dto);

    void delete(Long id);

    Status getEntityById(Long id);
    Status getEntityByName(String name);
}
