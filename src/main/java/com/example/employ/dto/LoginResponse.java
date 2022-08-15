package com.example.employ.dto;

public class LoginResponse {

    private String status;
    private String message;
    private String token;
    private String userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public LoginResponse(String status, String token, String message, String userId) {
        this.status = status;
        this.message = message;
        this.userId = userId;
        this.token = token;
    }

    public LoginResponse() {
    }
}
