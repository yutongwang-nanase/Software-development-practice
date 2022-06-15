package com.example.demo.server.handler;

import com.example.demo.server.domain.http.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData exceptionHandler(Exception e) {
        return ResultData.failure(e.getLocalizedMessage());
    }
}

