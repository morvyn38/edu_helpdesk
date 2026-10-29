package ru.diploma.eduhelpdesk.dto.request.Computer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComputerRequestCreateDto {

    @NotBlank(message = "hostname не может быть")
    @Size(max = 255, message = "hostname не может быть превышать 255 символов")
    private String hostname;

    @NotBlank(message = "ip address не может быть пустым")
    @Pattern(
            regexp = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$",
            message = "ip address должен быть корректным IPv4-адресом"
    )
    private String ipAddress;

    @NotBlank(message = "mac address не может быть пустым")
    @Pattern(
            regexp = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$",
            message = "macAddress должен быть в формате XX:XX:XX:XX:XX:XX"
    )
    private String macAddress;

    @NotBlank(message = "location не может быть пустым")
    @Size(max = 255, message = "location не должен превышать 255 символов")
    private String location;

    @NotNull(message = "isActive не должен быть пустым")
    private Boolean isActive;
}
