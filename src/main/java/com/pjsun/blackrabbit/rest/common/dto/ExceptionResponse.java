package com.pjsun.blackrabbit.rest.common.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExceptionResponse {

    private LocalDateTime timestamp;
    private String message;
    private String details;
    private List<FieldError> error;

    @Builder(builderClassName = "of", builderMethodName = "of")
    private ExceptionResponse(String message, String details, LocalDateTime timestamp, List<FieldError> error) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
        this.error = error;
    }
    @Builder(builderClassName = "sendBuilder", builderMethodName = "sendBuilder")
    public static ExceptionResponse send(String message, String details, LocalDateTime timestamp, List<FieldError> error) {
        return ExceptionResponse.of()
                .message(message)
                .details(details)
                .timestamp(timestamp)
                .error(error)
                .build();
    }
}
