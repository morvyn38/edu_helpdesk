package ru.diploma.eduhelpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diploma.eduhelpdesk.dto.request.User.UserRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.response.User.UserResponseDto;
import ru.diploma.eduhelpdesk.model.User;
import ru.diploma.eduhelpdesk.repository.UserRepository;
import ru.diploma.eduhelpdesk.service.RoleService;
import ru.diploma.eduhelpdesk.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public UserResponseDto create(UserRequestCreateDto dto) {
        User user = new User();

        user.setUsername(dto.getUsername());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPassword());
        user.setRole(roleService.getEntityById(dto.getRoleId()));
        user.setIsActive(dto.getIsActive());

        return toResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(Long id, UserRequestCreateDto dto) {
        User existUser = userRepository.findById(id).orElseThrow();

        existUser.setUsername(dto.getUsername());
        existUser.setFullName(dto.getFullName());
        existUser.setEmail(dto.getEmail());
        existUser.setRole(roleService.getEntityById(dto.getRoleId()));
        existUser.setIsActive(dto.getIsActive());

        return toResponseDto(userRepository.save(existUser));
    }

    @Override
    public UserResponseDto getById(Long id) {
        return toResponseDto(userRepository.findById(id).orElseThrow());
    }

    @Override
    public UserResponseDto getByUsername(String username) {
        return toResponseDto(userRepository.findByUsername(username).orElseThrow());
    }

    @Override
    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public List<UserResponseDto> getByRoleId(int roleId) {
        return userRepository.findByRoleId(roleId).stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getEntityById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public UserResponseDto toResponseDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getUsername(),
                user.getFullName(),
                user.getEmail(),
                user.getRole().getName(),
                user.getIsActive()
        );
    }
}
