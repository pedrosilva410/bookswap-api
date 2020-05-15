package com.bookswap.services;

        import com.bookswap.data.entities.AccountEntity;
        import com.bookswap.data.repositories.AccountRepository;
        import com.bookswap.http.models.Account;
        import com.bookswap.http.models.Token;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Service;

        import java.util.UUID;

@Service
public class AuthenticationService {
    private final AccountRepository accountRepository;

    public AuthenticationService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Token Authenticate(String userName, String password){

        AccountEntity accountEntity = accountRepository.findByUserName(userName);
        if(accountEntity!=null){
            if(accountEntity.getPassword().equals(password)){
                return new Token(UUID.randomUUID().toString(), true);
            } else {
                return new Token(null, false);
            }
        } else{
            return new Token(null, false);
        }
    }
}
