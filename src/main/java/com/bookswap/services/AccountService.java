package com.bookswap.services;

import com.bookswap.data.entities.AccountEntity;
import com.bookswap.data.repositories.AccountRepository;
import com.bookswap.http.models.Account;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account newAccount){

        //create new account
        var entity = new AccountEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setUserName(newAccount.getUserName());
        entity.setEmail(newAccount.getEmail());
        entity.setPassword(newAccount.getPassword());
        entity.setBio(newAccount.getBio());
        entity.setContact(newAccount.getContact());

        // save account
        var saveEntity = this.accountRepository.save(entity);
        return new Account(saveEntity.getId(), saveEntity.getUserName(), saveEntity.getEmail(), saveEntity.getPassword(), saveEntity.getBio(), saveEntity.getContact());
    }

    /*public Account editAccount(String accountId, Account newAccountDetails){

        Account storedAccountDetails = getAccount(accountId);

        storedAccountDetails.setUserName(newAccountDetails.getUserName());
        storedAccountDetails.setBio(newAccountDetails.getBio());
        storedAccountDetails.setEmail(newAccountDetails.getEmail());
        storedAccountDetails.setContact(newAccountDetails.getContact());
        storedAccountDetails.setPassword(newAccountDetails.getPassword());

        return storedAccountDetails;
    }*/

    public Account getAccount(String id){
        return accountRepository.findById(id).map(this::mapFromAccountEntity).get();
    }

    private Account mapFromAccountEntity(AccountEntity accountEntity){
        return new Account(accountEntity.getId(), accountEntity.getUserName(), accountEntity.getEmail(), null, accountEntity.getBio(), accountEntity.getContact());
    }
}
