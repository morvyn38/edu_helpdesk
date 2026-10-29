package ru.diploma.eduhelpdesk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.diploma.eduhelpdesk.dto.request.Status.StatusRequestCreateDto;
import ru.diploma.eduhelpdesk.model.Status;
import ru.diploma.eduhelpdesk.repository.StatusRepository;
import ru.diploma.eduhelpdesk.service.impl.StatusServiceImpl;
import ru.diploma.eduhelpdesk.enums.StatusEnum;

@Component
@RequiredArgsConstructor
public class DataStatusInitializer implements CommandLineRunner {

    @Autowired
    private StatusRepository statusRepository;

    @Override // ИНИЦИАЛИЗАЦИЯ СТАТУСОВ
    public void run(String... args) throws Exception {

        if (statusRepository.count() > 0) {
            return;
        }

        for (StatusEnum status : StatusEnum.values()) {
            Status newStatus = new Status();

            newStatus.setName(status.getDbName());
            newStatus.setIsFinal(status.getIsFinal());

            statusRepository.save(newStatus);
        }
        System.out.println("Все СТАТУСЫ проинициализированы!");
    }
}
