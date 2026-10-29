package ru.diploma.eduhelpdesk.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import ru.diploma.eduhelpdesk.dto.error.ErrorResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {

        // Извлечь ошибки валидации всех полей
        List<ErrorResponse.ValidationError> validationErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> new ErrorResponse.ValidationError(
                        error.getField(),
                        error.getDefaultMessage()))
                .collect(Collectors.toList());

        ErrorResponse body = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Validation failed",
                request.getDescription(false).replace("uri=", ""), // получить path
                validationErrors
        );

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(DuplicateFieldException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateFieldExceptions(DuplicateFieldException ex, WebRequest request) {

        String userMessage = ex.getMessage();

        ErrorResponse body = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                "Conflict",
                userMessage,
                request.getDescription(false).replace("uri=", ""),
                null // validationErrors не нужны
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(NoElementException.class)
    public ResponseEntity<ErrorResponse> handleNoElementExceptions(NoElementException ex, WebRequest request) {
        String userMessage = ex.getMessage();

        ErrorResponse body = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                userMessage,
                request.getDescription(false).replace("uri=", ""),
                null // validationErrors не нужны
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

}