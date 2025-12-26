package com.example.demo.dto;

public class ApiResponse {
    private boolean success;
    private String message;
    private Object token;

    public ApiResponse(boolean success, String message, Object token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }
    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Object getData() { return token; }
}