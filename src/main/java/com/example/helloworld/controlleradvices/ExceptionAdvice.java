package com.example.helloworld.controlleradvices;

import com.example.helloworld.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @className: ExceptionAdvice
 * @author: ZhangLiZhi
 * @date: 2021-08-18
 */

@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @Autowired
    private HttpServletRequest request;

    @ExceptionHandler(Exception.class)
    public ResponseEntity solveException(Exception e) {
        request.setAttribute("res", null);
        log.error(e.getMessage());
        return ResponseEntity.exception(500, "服务器异常:" + e.getMessage());
    }
}
