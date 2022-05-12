package com.example.web.common;

import com.example.web.entity.User;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public boolean isSuccess() {
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public static <T> ServerResponse<T> successWithMsgData(String msg, T data) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static <T> ServerResponse<T> successWithData(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), null, data);
    }

    public static <T> ServerResponse<T> success() {
        return new ServerResponse<>(0,null,null);
    }

    public static <T> ServerResponse<T> successWithMsg(String msg) {
        return new ServerResponse<>(ResponseCode.SUCCESS.getCode(), msg, null);
    }

    public static ServerResponse<User> failWithMsg(String msg) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg, null);
    }

    public static <T> ServerResponse<T> failWithMsgData(String msg) {
        return new ServerResponse<>(ResponseCode.ERROR.getCode(), msg, null);
    }

    public  static <T> ServerResponse<T> failWithMsgData(int code,String msg) {
        return new ServerResponse<>(code,msg,null);

    }

    public static <T> ServerResponse<T> failWithCodeMsg(int code, String msg) {
        return new ServerResponse<>(code,msg,null);
    }



}
