package com.pjsun.blackrabbit.rest.common.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpErrorCode {

    OK("E200","OK"),
    CREATED("E201","Created"),
    ACCEPTED("E202","Accepted:Batch Processing"),
    NO_CONTENT("E204","No Content"),
    BAD_REQUEST("400","Bad Request"),
    UNAUTHORIZED("401","Unauthorized"),
    FORBIDDEN("403","Forbidden"),
    NOT_FOUND("404","Not Found"),
    INTERNAL_SERVER_ERROR("500","Internal Server Error"),
    SERVICE_UNAVAILABLE("503","Service Unavailable"),
    BAD_GATEWAY("504","Bad Gateway Timeout");

    private final String code;
    private final String message;
}
