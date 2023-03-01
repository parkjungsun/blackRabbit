package com.pjsun.blackrabbit.rest.common.controllerAdvice;

import com.pjsun.blackrabbit.rest.common.dto.ExceptionResponse;
import com.pjsun.blackrabbit.rest.common.dto.FieldError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice(basePackages = "com.pjsun.blackrabbit.rest")
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        log.error("CommonControllerAdvice.handleMethodArgumentNotValid: " + ex.getClass().getName());

        List<FieldError> errorList = ex.getBindingResult().getFieldErrors()
                .stream().map(err -> FieldError.builder()
                            .field(err.getField())
                            .rejectedValue(err.getRejectedValue())
                            .message(err.getDefaultMessage())
                            .build())
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ExceptionResponse.sendBuilder()
                        .timestamp(LocalDateTime.now())
                        .message("Arguments are not valid")
                        .details(ex.getClass().getName())
                        .error(errorList)
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> commonException(Exception e) {
        log.error("CommonControllerAdvice.commonException: " + e.getClass().getName());

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExceptionResponse.sendBuilder()
                        .timestamp(LocalDateTime.now())
                        .message("UNKNOWN Exception")
                        .details(e.getClass().getName())
                        .build());
    }
}
