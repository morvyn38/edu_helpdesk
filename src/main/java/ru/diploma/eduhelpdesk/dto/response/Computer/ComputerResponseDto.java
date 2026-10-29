package ru.diploma.eduhelpdesk.dto.response.Computer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComputerResponseDto {
    private Long id;
    private String hostname;
    private String ipAddress;
    private String macAddress;
    private String location;
    private Boolean isActive;
    private LocalDateTime lastSeenAt;
    private LocalDateTime createdAt;
}
