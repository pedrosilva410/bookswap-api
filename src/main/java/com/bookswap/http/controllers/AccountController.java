package com.bookswap.http.controllers;

import com.bookswap.http.models.Account;
import com.bookswap.services.AccountService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    public ResponseEntity<Void> createAccount(@RequestBody Account account){
        var newAccount = accountService.createAccount(account);
        return ResponseEntity.created(getAccountResourceURI(newAccount.getId())).build();
    }

    @GetMapping("/account/{accountId}")
    public Account getAccount(@PathVariable("accountId")String accountId) {
        return accountService.getAccount(accountId);
    }

    /*@PutMapping("/account/{accountId}")
    public ResponseEntity<Void> editAccount(@PathVariable("accountId") String accountId, @RequestBody Account editAccount){
        var editedAccount = accountService.editAccount(accountId, editAccount);
        return ResponseEntity.accepted().build();
    }*/

    private URI getAccountResourceURI(String id){
        return URI.create(String.format("/account/%s", id));
    }
}
