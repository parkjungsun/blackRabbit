package com.pjsun.blackrabbit.rest.common.controller;

import com.pjsun.blackrabbit.rest.common.code.HttpErrorCode;
import com.pjsun.blackrabbit.rest.common.dto.MessageResponse;
import com.pjsun.blackrabbit.rest.common.dto.SampleRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 공통 api
 * @author parkjungsun
 * @date 2023.03.01
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/common")
public class CommonController {
    /**
    * Http API Test
    * @ param:
    * @ return:
    * @ exception:
    * */
    @PostMapping("/test")
    public ResponseEntity<MessageResponse> test (
            @RequestBody @Valid SampleRequestDto data) throws Exception {
        log.info("service api test");

        if(data.getDivision().equals(200L)) return ResponseEntity.status(HttpStatus.OK).body(MessageResponse.send(HttpErrorCode.OK.getMessage()));
        if(data.getDivision().equals(201L)) return ResponseEntity.status(HttpStatus.CREATED).body(MessageResponse.send(HttpErrorCode.CREATED.getMessage()));
        if(data.getDivision().equals(202L)) return ResponseEntity.status(HttpStatus.ACCEPTED).body(MessageResponse.send(HttpErrorCode.ACCEPTED.getMessage()));
        if(data.getDivision().equals(204L)) return ResponseEntity.status(HttpStatus.NO_CONTENT).body(MessageResponse.send(HttpErrorCode.NO_CONTENT.getMessage()));
        if(data.getDivision().equals(400L)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MessageResponse.send(HttpErrorCode.BAD_REQUEST.getMessage()));
        if(data.getDivision().equals(401L)) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(MessageResponse.send(HttpErrorCode.UNAUTHORIZED.getMessage()));
        if(data.getDivision().equals(403L)) return ResponseEntity.status(HttpStatus.FORBIDDEN).body(MessageResponse.send(HttpErrorCode.FORBIDDEN.getMessage()));
        if(data.getDivision().equals(404L)) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(MessageResponse.send(HttpErrorCode.NOT_FOUND.getMessage()));
        if(data.getDivision().equals(500L)) return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(MessageResponse.send(HttpErrorCode.INTERNAL_SERVER_ERROR.getMessage()));
        if(data.getDivision().equals(503L)) return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(MessageResponse.send(HttpErrorCode.SERVICE_UNAVAILABLE.getMessage()));
        if(data.getDivision().equals(504L)) return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(MessageResponse.send(HttpErrorCode.BAD_GATEWAY.getMessage()));

        throw new Exception("API TEST");
    }
}
