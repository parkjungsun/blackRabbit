package com.pjsun.blackrabbit.rest.common.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@ToString
@Getter @Setter
public class FieldError {
    private String field;
    private Object rejectedValue;
    private String message;
}
