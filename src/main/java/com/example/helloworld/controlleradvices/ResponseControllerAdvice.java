package com.example.helloworld.controlleradvices;

import com.example.helloworld.utils.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO
 *
 * @className: ResponseControllerAdvice
 * @author: ZhangLiZhi
 * @date: 2021-08-18
 **/

@ControllerAdvice
public class ResponseControllerAdvice implements ResponseBodyAdvice {

    @Autowired
    private HttpServletRequest request;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return request.getAttribute("res") != null;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof String) {
            return new ObjectMapper().writeValueAsString(ResponseEntity.success(o));
        }
        return ResponseEntity.success(o);
    }
}

