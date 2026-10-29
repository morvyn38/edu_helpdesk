package ru.diploma.eduhelpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diploma.eduhelpdesk.dto.request.Status.StatusRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Status.StatusRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Status.StatusResponseDto;
import ru.diploma.eduhelpdesk.enums.StatusEnum;
import ru.diploma.eduhelpdesk.model.Status;
import ru.diploma.eduhelpdesk.repository.StatusRepository;
import ru.diploma.eduhelpdesk.service.StatusService;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public StatusResponseDto create(StatusRequestCreateDto dto) {
        Status status = new Status();

        status.setName(dto.getName());
        status.setIsFinal(dto.getIsFinal());

        return toResponseDto(statusRepository.save(status));
    }

    @Override
    public StatusResponseDto getById(Long id) {
        return toResponseDto(statusRepository.findById(id).orElseThrow());
    }

    @Override
    public StatusResponseDto getByName(String name) {
        return toResponseDto(statusRepository.getByName(name).orElseThrow());
    }

    @Override
    public List<StatusResponseDto> getAll() {
        return statusRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public StatusResponseDto update(Long id, StatusRequestUpdateDto dto) {
        Status existStatus = statusRepository.findById(id).orElseThrow();

        existStatus.setName(dto.getName());

        return toResponseDto(statusRepository.save(existStatus));
    }

    @Override
    public void delete(Long id) {
        statusRepository.deleteById(id);
    }

    @Override
    public Status getEntityById(Long id) {
        return statusRepository.findById(id).orElseThrow();
    }

    @Override
    public Status getEntityByName(String name) { return statusRepository.getByName(name).orElseThrow(); }

    public StatusResponseDto toResponseDto(Status status) {

        StatusEnum statusEnum = StatusEnum.fromDbName(status.getName());

        return new StatusResponseDto(
                status.getId(),
                status.getName(),
                statusEnum.getDisplayName(),
                status.getIsFinal()
        );
    }
}
