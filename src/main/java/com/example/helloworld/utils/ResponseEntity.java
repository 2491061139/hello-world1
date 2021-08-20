package com.example.helloworld.utils;

import java.io.Serializable;

/**
 * TODO
 *
 * @className: ResponseEntity
 * @author: ZhangLiZhi
 * @date: 2021-08-18
 **/

public class ResponseEntity implements Serializable {

    private Integer statusCode;

    private String message;

    private Object result;

    private String error;

    public static ResponseEntity success(Object ans) {
        return new ResponseEntity(200, "请求成功", ans, "success");
    }

    public static ResponseEntity exception(Integer code, String message) {
        return new ResponseEntity(code, message, null, "error");
    }

    public ResponseEntity() {
    }

    public ResponseEntity(Integer statusCode, String message, Object result, String error) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
        this.error = error;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statuscode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "statuscode=" + statusCode +
                ", message='" + message + '\'' +
                ", result=" + result.toString() +
                ", error='" + error + '\'' +
                '}';
    }
}
