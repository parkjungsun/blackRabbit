package com.pjsun.blackrabbit.rest.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter @Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    @Builder(builderClassName = "of", builderMethodName = "of")
    private MessageResponse(String message) {
        this.message = message;
    }

    @Builder(builderClassName = "sendBuilder", builderMethodName = "sendBuilder")
    public static MessageResponse send(String message) {
        return MessageResponse.of()
                .message(message)
                .build();
    }
}
