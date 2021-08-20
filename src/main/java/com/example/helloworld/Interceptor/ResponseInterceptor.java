
package com.example.helloworld.Interceptor;

import com.example.helloworld.annotation.ResponseAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
 * TODO
 *
 * @className: ResponseInterceptor
 * @author: ZhangLiZhi
 * @date: 2021-08-18
 **/


@Component
@Slf4j
public class ResponseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod) {

            Class<?> clazz = ((HandlerMethod) handler).getBeanType();
            Method method = ((HandlerMethod) handler).getMethod();

            if(clazz.isAnnotationPresent(ResponseAnnotation.class)) {
                log.info("类上有responseControllerAdvice注解");
                request.setAttribute("res", true);
            } else if(method.isAnnotationPresent(ResponseAnnotation.class)) {
                log.info("方法有responseControllerAdvice注解");
                request.setAttribute("res", true);
            } else {
                log.info("没有responseControllerAdvice注解");
            }
        }
        return true;
    }

}

