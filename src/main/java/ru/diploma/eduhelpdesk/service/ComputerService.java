package ru.diploma.eduhelpdesk.service;

import ru.diploma.eduhelpdesk.dto.request.Computer.ComputerRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Computer.ComputerRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Computer.ComputerResponseDto;
import ru.diploma.eduhelpdesk.model.Computer;

import java.util.List;

public interface ComputerService {
    ComputerResponseDto create(ComputerRequestCreateDto computer);
    ComputerResponseDto update(Long id, ComputerRequestUpdateDto computer);
    ComputerResponseDto getById(Long id);
    ComputerResponseDto getByHostname(String hostname);
    ComputerResponseDto getByIpAddress(String ipAddress);
    ComputerResponseDto getByMacAddress(String macAddress);

    List<ComputerResponseDto> getAll();

    void delete(Long id);

    Computer getEntityById(Long id);
}
