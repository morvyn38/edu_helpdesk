package ru.diploma.eduhelpdesk.service;

import ru.diploma.eduhelpdesk.dto.request.Role.RoleRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Role.RoleRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Role.RoleResponseDto;
import ru.diploma.eduhelpdesk.model.Role;

import java.util.List;

public interface RoleService {
    RoleResponseDto create(RoleRequestCreateDto role);
    RoleResponseDto getById(Long id);
    RoleResponseDto getByName(String name);
    List<RoleResponseDto> getAll();

    RoleResponseDto update(Long id, RoleRequestUpdateDto role);

    void delete(Long id);

    Role getEntityById(Long id);
}
