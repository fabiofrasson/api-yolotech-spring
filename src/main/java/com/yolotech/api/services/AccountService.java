package com.yolotech.api.services;

import com.yolotech.api.entities.Account;
import com.yolotech.api.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

  @Autowired private AccountRepository accountRepository;

  public List<Account> findAll() {
    return accountRepository.findAll();
  }

  public Account findById(Long id) {
    Optional<Account> optionalAccount = accountRepository.findById(id);
    return optionalAccount.get();
  }

  public Account insert(Account account) {
    return accountRepository.save(account);
  }

  public void delete(Long id) {
    accountRepository.deleteById(id);
  }
}
