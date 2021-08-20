package com.example.helloworld.controllers;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * TODO
 *
 * @className: RequestStu
 * @author: ZhangLiZhi
 * @date: 2021-08-19
 **/

@Document(collation = "demo")
@Data
public class RequestStu {
    private String name;
    private Integer num;
}
