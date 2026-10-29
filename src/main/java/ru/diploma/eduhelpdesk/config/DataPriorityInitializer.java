package ru.diploma.eduhelpdesk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.diploma.eduhelpdesk.enums.PriorityEnum;
import ru.diploma.eduhelpdesk.model.Priority;
import ru.diploma.eduhelpdesk.repository.PriorityRepository;

@Component
@RequiredArgsConstructor
public class DataPriorityInitializer implements CommandLineRunner {

    @Autowired
    private PriorityRepository priorityRepository;

    @Override
    public void run(String... args) throws Exception {

        if (priorityRepository.count() > 0) {
            return;
        }

        for (PriorityEnum priorityEnum : PriorityEnum.values()) {
            Priority priority = new Priority();

            priority.setLevel(priorityEnum.getLevel());
            priority.setName(priorityEnum.getName());

            priorityRepository.save(priority);
        }

        System.out.println("Все ПРИОРИТЕТЫ проинициализированы!");
    }
}
