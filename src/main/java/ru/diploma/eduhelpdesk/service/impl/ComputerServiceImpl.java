package ru.diploma.eduhelpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diploma.eduhelpdesk.dto.request.Computer.ComputerRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Computer.ComputerRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Computer.ComputerResponseDto;
import ru.diploma.eduhelpdesk.exception.DuplicateFieldException;
import ru.diploma.eduhelpdesk.exception.NoElementException;
import ru.diploma.eduhelpdesk.model.Computer;
import ru.diploma.eduhelpdesk.repository.ComputerRepository;
import ru.diploma.eduhelpdesk.service.ComputerService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComputerServiceImpl implements ComputerService {

    @Autowired
    private ComputerRepository compRepository;

    @Override
    public ComputerResponseDto create(ComputerRequestCreateDto computer) {

        if (compRepository.existsByHostname(computer.getHostname())) {
            throw new DuplicateFieldException("hostname", "Компьютер с таким hostname уже существует");
        }
        if (compRepository.existsByIpAddress(computer.getIpAddress())) {
            throw new DuplicateFieldException("ipAddress", "Компьютер с таким ipAddress уже существует");
        }
        if (compRepository.existsByMacAddress(computer.getMacAddress())) {
            throw new DuplicateFieldException("macAddress", "Компьютер с таким macAddress уже существует");
        }

        Computer comp = new Computer();

        comp.setHostname(computer.getHostname());
        comp.setLocation(computer.getLocation());
        comp.setIpAddress(computer.getIpAddress());
        comp.setMacAddress(computer.getMacAddress().toUpperCase());
        comp.setCreatedAt(LocalDateTime.now());
        comp.setLastSeenAt(null);
        comp.setIsActive(computer.getIsActive());

        return toResponseDto(compRepository.save(comp));
    }

    @Override
    public ComputerResponseDto update(Long id, ComputerRequestUpdateDto computer) {
        if (!compRepository.existsById(id)) {
            throw new NoElementException("Компьютера с таким ID не существует");
        }
        if (compRepository.existsByHostname(computer.getHostname())) {
            throw new DuplicateFieldException("hostname", "Компьютер с таким hostname уже существует");
        }
        if (compRepository.existsByIpAddress(computer.getIpAddress())) {
            throw new DuplicateFieldException("ipAddress", "Компьютер с таким ipAddress уже существует");
        }
        if (compRepository.existsByMacAddress(computer.getMacAddress())) {
            throw new DuplicateFieldException("macAddress", "Компьютер с таким macAddress уже существует");
        }

        Computer existComp = compRepository.findById(id).orElseThrow();

        existComp.setIsActive(computer.getIsActive());
        existComp.setHostname(computer.getHostname());
        existComp.setLocation(computer.getLocation());
        existComp.setIpAddress(computer.getIpAddress());
        existComp.setMacAddress(computer.getMacAddress().toUpperCase());

        return toResponseDto(compRepository.save(existComp));
    }

    @Override
    public ComputerResponseDto getById(Long id) {
        if (!compRepository.existsById(id)) {
            throw new NoElementException("Компьютера с таким ID не существует");
        }
        return toResponseDto(compRepository.findById(id).orElseThrow());
    }

    @Override
    public ComputerResponseDto getByHostname(String hostname) {
        if (!compRepository.existsByHostname(hostname)) {
            throw new NoElementException("Компьютера с таким Hostname не существует");
        }
        return toResponseDto(compRepository.getByHostname(hostname).orElseThrow());
    }

    @Override
    public ComputerResponseDto getByIpAddress(String ipAddress) {
        if (!compRepository.existsByIpAddress(ipAddress)) {
            throw new NoElementException("Компьютера с таким ipAddress не существует");
        }
        return toResponseDto(compRepository.getByIpAddress(ipAddress).orElseThrow());
    }

    @Override
    public ComputerResponseDto getByMacAddress(String macAddress) {
        if (!compRepository.existsByMacAddress(macAddress)) {
            throw new NoElementException("Компьютера с таким macAddress не существует");
        }
        return toResponseDto(compRepository.getByMacAddress(macAddress).orElseThrow());
    }

    @Override
    public List<ComputerResponseDto> getAll() {
        return compRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        if (!compRepository.existsById(id)) {
            throw new NoElementException("Компьютера с таким ID не существует");
        }
        compRepository.deleteById(id);
    }

    @Override
    public Computer getEntityById(Long id) {
        return compRepository.findById(id).orElseThrow();
    }

    public ComputerResponseDto toResponseDto(Computer comp) {
        return new ComputerResponseDto(
                comp.getId(),
                comp.getHostname(),
                comp.getIpAddress(),
                comp.getMacAddress(),
                comp.getLocation(),
                comp.getIsActive(),
                comp.getLastSeenAt(),
                comp.getCreatedAt()
        );
    }
}
