package com.example.demo.payload;

public class ApiResponse {

    private boolean success;
    private String message;
    private Object data;

    // ===== Constructors =====

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // ===== Static helper methods (optional but useful) =====

    public static ApiResponse success(String message, Object data) {
        return new ApiResponse(true, message, data);
    }

    public static ApiResponse success(String message) {
        return new ApiResponse(true, message);
    }

    public static ApiResponse failure(String message) {
        return new ApiResponse(false, message);
    }

    // ===== Getters =====

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
