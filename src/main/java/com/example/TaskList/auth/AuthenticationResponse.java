package com.example.TaskList.auth;

public class AuthenticationResponse {
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }

    private final String jwt;
}
