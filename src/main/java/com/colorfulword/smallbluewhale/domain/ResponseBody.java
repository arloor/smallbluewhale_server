package com.colorfulword.smallbluewhale.domain;

/**
 * 接口返回统一格式
 * Created by jone.sun on 2017/7/2.
 */
public class ResponseBody<T> {
    private int code;
    private String message;
    private T data;

    public ResponseBody(){}

    public ResponseBody(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
