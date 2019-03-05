package com.example.demo.domain;

import java.io.Serializable;

public class RestResponse implements Serializable {
    private int code;
    private boolean flag;
    private String message;
    private Object object;

    public RestResponse() {
    }

    public static RestResponse success(Object object){
        RestResponse response = new RestResponse();
        response.setFlag(true);
        response.setCode(0);
        response.setMessage("success");
        response.setObject(object);
        return response;
    }

    public static RestResponse success(){
        RestResponse response = new RestResponse();
        response.setFlag(true);
        response.setCode(0);
        response.setMessage("success");
        response.setObject(null);
        return response;
    }

    public static RestResponse fail(String message){
        RestResponse response = new RestResponse();
        response.setFlag(false);
        response.setCode(1);
        response.setMessage(message);
        return response;
    }

    public static RestResponse fail(String message,Object object){
        RestResponse response = new RestResponse();
        response.setFlag(false);
        response.setCode(1);
        response.setMessage(message);
        response.setObject(object);
        return response;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }


    public RestResponse(int code, boolean flag, String message, Object object) {
        this.code = code;
        this.flag = flag;
        this.message = message;
        this.object = object;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "code=" + code +
                ", flag=" + flag +
                ", message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
