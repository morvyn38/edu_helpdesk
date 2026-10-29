package ru.diploma.eduhelpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.diploma.eduhelpdesk.model.Computer;

import java.util.Optional;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {
    Optional<Computer> getByHostname(String hostname);
    Optional<Computer> getByIpAddress(String ipAddress);
    Optional<Computer> getByMacAddress(String macAddress);
    boolean existsByHostname(String hostname);
    boolean existsByIpAddress(String ipAddress);
    boolean existsByMacAddress(String macAddress);

}
