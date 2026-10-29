package ru.diploma.eduhelpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diploma.eduhelpdesk.dto.request.Role.RoleRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Role.RoleRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Role.RoleResponseDto;
import ru.diploma.eduhelpdesk.exception.DuplicateFieldException;
import ru.diploma.eduhelpdesk.exception.NoElementException;
import ru.diploma.eduhelpdesk.model.Role;
import ru.diploma.eduhelpdesk.repository.RoleRepository;
import ru.diploma.eduhelpdesk.service.RoleService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDto create(RoleRequestCreateDto dto) {
        if (roleRepository.existsByName(dto.getName())) {
            throw new DuplicateFieldException("name", "Роль с таким именем уже существует");
        }

        Role role = new Role();

        role.setName(dto.getName());
        role.setCreatedAt(LocalDateTime.now());

        return toResponseDto(roleRepository.save(role));
    }

    @Override
    public RoleResponseDto getById(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new NoElementException("Роли с таким ID не существует");
        }

        return toResponseDto(roleRepository.findById(id).orElseThrow());
    }

    @Override
    public RoleResponseDto getByName(String name) {
        if (!roleRepository.existsByName(name)) {
            throw new NoElementException(name);
        }
        return toResponseDto(roleRepository.getByName(name).orElseThrow());
    }

    @Override
    public List<RoleResponseDto> getAll() {
        return roleRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public RoleResponseDto update(Long id, RoleRequestUpdateDto role) {
        if (!roleRepository.existsById(id)) {
            throw new NoElementException("Роли с таким ID не существует");
        }
        if (roleRepository.existsByName(role.getName())) {
            throw new DuplicateFieldException("name", "Роль с таким именем уже существует");
        }

        Role existRole = roleRepository.findById(id).orElseThrow();

        existRole.setName(role.getName());

        return toResponseDto(roleRepository.save(existRole));
    }

    @Override
    public void delete(Long id) {
        if (!roleRepository.existsById(id)) {
            throw new NoElementException("Роли с таким ID не существует");
        }
        roleRepository.deleteById(id);
    }

    @Override
    public Role getEntityById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    private RoleResponseDto toResponseDto(Role role) {
        return new RoleResponseDto(
                role.getId(),
                role.getName(),
                role.getCreatedAt()
        );
    }
}
