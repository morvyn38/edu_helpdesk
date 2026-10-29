package ru.diploma.eduhelpdesk.contoller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.diploma.eduhelpdesk.dto.error.ErrorResponse;
import ru.diploma.eduhelpdesk.dto.request.Computer.ComputerRequestCreateDto;
import ru.diploma.eduhelpdesk.dto.request.Computer.ComputerRequestUpdateDto;
import ru.diploma.eduhelpdesk.dto.response.Computer.ComputerResponseDto;
import ru.diploma.eduhelpdesk.service.impl.ComputerServiceImpl;

import java.util.List;

@Tag(name = "Computer Management", description = "Операции с компьютерами")
@RestController
@RequestMapping("/api/computers")
public class ComputerController {

    @Autowired
    private ComputerServiceImpl compService;

    @Operation(summary = "Получить все компьютеры")
    @GetMapping
    public List<ComputerResponseDto> getAll() {
        return compService.getAll();
    };

    @Operation(summary = "Получить компьютер по ID")
    @GetMapping("/{id}")
    public ComputerResponseDto getById(@PathVariable Long id) {
        return compService.getById(id);
    }

    @Operation(summary = "Получить компьютер по Hostname")
    @GetMapping("/by-hostname/{hostname}")
    public ComputerResponseDto getByHostname(@PathVariable String hostname) {
        return compService.getByHostname(hostname);
    }

    @Operation(summary = "Получить компьютер по Mac адресу")
    @GetMapping("/by-mac-address/{macAddress}")
    public ComputerResponseDto getByMacAddress(@PathVariable String macAddress) {
        return compService.getByMacAddress(macAddress);
    }

    @Operation(summary = "Получить компьютер по IP адресу")
    @GetMapping("/by-ip-address/{ipAddress}")
    public ComputerResponseDto getByIpAddress(@PathVariable String ipAddress) {
        return compService.getByIpAddress(ipAddress);
    }

    @Operation(summary = "Создать компьютер")
    @PostMapping
    public ComputerResponseDto create(@Valid @RequestBody ComputerRequestCreateDto dto) {
        return compService.create(dto);
    }

    @Operation(summary = "Обновить компьютер")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Компьютер успешно обновлен"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка валидации полей",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Компьютер с указанным ID не найден",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Конфликт данных (дубликат IP или MAC)",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            )
    })
    @PutMapping("/{id}")
    public ComputerResponseDto update(@PathVariable Long id, @Valid @RequestBody ComputerRequestUpdateDto dto) {
        return compService.update(id, dto);
    }

    @Operation(summary = "Удалить компьютер")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        compService.delete(id);
    }
}
