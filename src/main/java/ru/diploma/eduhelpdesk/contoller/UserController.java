package ru.diploma.eduhelpdesk.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.diploma.eduhelpdesk.dto.request.User.UserRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.response.User.UserResponseDto;
import ru.diploma.eduhelpdesk.service.UserService;

import java.util.List;

@Tag(name = "User Management", description = "Операции с пользователями")
@RestController
@RequestMapping("/api/users")
class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Создать пользователя")
    @PostMapping
    public UserResponseDto create(@Valid @RequestBody UserRequestCreateDto dto) {
        return userService.create(dto);
    }

    @Operation(summary = "Получить пользователя по ID")
    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @Operation(summary = "Получить пользователя по username")
    @GetMapping("/by-username/{username}")
    public UserResponseDto getByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @Operation(summary = "Получить всех пользователей")
    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll();
    }

    @Operation(summary = "Получить пользователя по roleId")
    @GetMapping("/by-role/{roleId}")
    public List<UserResponseDto> getByRoleId(@PathVariable int roleId) {
        return userService.getByRoleId(roleId);
    }

    @Operation(summary = "Изменить пользователя")
    @PutMapping("/{id}")
    public UserResponseDto update(@Valid @PathVariable Long id, @RequestBody UserRequestCreateDto user) {
        return userService.update(id, user);
    }

    @Operation(summary = "Удалить пользователя по id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}