package com.bookswap.http.models;

public class Token {
    String token;
    boolean authenticated;
    String userId;

    public Token(String token, boolean authenticated, String userId) {
        this.token = token;
        this.authenticated = authenticated;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
