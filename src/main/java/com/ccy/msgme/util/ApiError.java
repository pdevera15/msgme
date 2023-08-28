package com.ccy.msgme.util;

public enum ApiError {
    USERNAME_ALREADY_EXISTS(101, "Username already exists"),
    PASSWORD_WEAK(103, "Password does not meet security requirements"),
    INVALID_CREDENTIALS(401, "Invalid username or password. Please check your credentials and try again.");
    
    
    private final int code;
    private final String message;
    
    ApiError(int code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return String.valueOf(code);
    }
    
    public String getMessage() {
        return message;
    }
    
}
