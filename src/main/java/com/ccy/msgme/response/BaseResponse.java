package com.ccy.msgme.response;

public class BaseResponse<T> {

    private String status;
    private String message;
    private T data;
    
    public BaseResponse(String status, String message, T data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }
    
    public BaseResponse() {}
    
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
