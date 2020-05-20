package com.bookswap.data.repositories;

import com.bookswap.data.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,  String> {
    public AccountEntity findByUserName(String userName);
}