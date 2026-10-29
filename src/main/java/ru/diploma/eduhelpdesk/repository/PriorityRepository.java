package ru.diploma.eduhelpdesk.repository;

import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diploma.eduhelpdesk.model.Category;
import ru.diploma.eduhelpdesk.model.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    Optional<Category> findByName(String name);
}
