package ru.diploma.eduhelpdesk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diploma.eduhelpdesk.dto.response.Priority.PriorityResponseDto;
import ru.diploma.eduhelpdesk.enums.PriorityEnum;
import ru.diploma.eduhelpdesk.model.Priority;
import ru.diploma.eduhelpdesk.repository.PriorityRepository;
import ru.diploma.eduhelpdesk.service.PriorityService;

import java.util.List;

@Service
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    private PriorityRepository priorityRepository;


    @Override
    public List<PriorityResponseDto> getAll() {
        return priorityRepository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public Priority getEntityById(Long id) {
        return priorityRepository.findById(id).orElseThrow();
    }

    public PriorityResponseDto toResponseDto(Priority priority) {
        return new PriorityResponseDto(
                priority.getId(),
                priority.getName(),
                PriorityEnum.fromName(priority.getName()).getDisplayName(),
                priority.getLevel()
        );
    }
}
