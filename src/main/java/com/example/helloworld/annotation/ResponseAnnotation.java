package com.example.helloworld.annotation;

import java.lang.annotation.*;

/**
 * TODO
 *
 * @className: ResponseAnnotation
 * @author: ZhangLiZhi
 * @date: 2021-8-18
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE , ElementType.METHOD})
@Documented
public @interface ResponseAnnotation {
}
