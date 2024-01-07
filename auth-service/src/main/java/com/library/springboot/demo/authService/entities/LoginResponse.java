package com.library.springboot.demo.authService.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    @Setter(onMethod_ = {@JsonProperty("expiresIn")})
    private long expiresIn;


    // Getter and setter for token
    // Getter and setter for expiresIn

    public LoginResponse setExpirationTime(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

}