package com.bookswap.http.controllers;

import com.bookswap.http.models.Autentication;
import com.bookswap.http.models.Token;
import com.bookswap.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authentication")
    public Token authenticate(@RequestBody Autentication autentication){
       return authenticationService.Authenticate(autentication.getUserName(), autentication.getPassword());
    }

}
