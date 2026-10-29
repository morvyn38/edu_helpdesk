package ru.diploma.eduhelpdesk.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.diploma.eduhelpdesk.dto.request.Role.RoleRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Role.RoleRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Role.RoleResponseDto;
import ru.diploma.eduhelpdesk.service.impl.RoleServiceImpl;

import java.util.List;

@Tag(name = "Roles Management", description = "Операции с ролями")
@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @Operation(summary = "Получить роль по ID")
    @GetMapping("/{id}")
    public RoleResponseDto getById(@PathVariable Long id) {
        return roleService.getById(id);
    }

    @Operation(summary = "Получить роль по имени")
    @GetMapping("/by-name/{name}")
    public RoleResponseDto getByName(@PathVariable String name) {
        return roleService.getByName(name);
    }

    @Operation(summary = "Получить все роли")
    @GetMapping
    public List<RoleResponseDto> getAll() {
        return roleService.getAll();
    }

    @Operation(summary = "Создать роль")
    @PostMapping
    public RoleResponseDto create(@RequestBody RoleRequestCreateDto dto) {
        return roleService.create(dto);
    }

    @Operation(summary = "Изменить роль")
    @PutMapping("/{id}")
    public RoleResponseDto update(@PathVariable Long id, @RequestBody RoleRequestUpdateDto dto) {
        return roleService.update(id, dto);
    }

    @Operation(summary = "Удалить роль")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roleService.delete(id);
    }

}
