package ru.diploma.eduhelpdesk.service;

import ru.diploma.eduhelpdesk.dto.request.User.UserRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.response.User.UserResponseDto;
import ru.diploma.eduhelpdesk.model.User;

import java.util.List;

public interface UserService {
    UserResponseDto create(UserRequestCreateDto user);
    UserResponseDto update(Long id, UserRequestCreateDto user);
    UserResponseDto getById(Long id);
    UserResponseDto getByUsername(String username);
    List<UserResponseDto> getAll();

    List<UserResponseDto> getByRoleId(int roleId);

    void delete(Long id);

    User getEntityById(Long id);
}
