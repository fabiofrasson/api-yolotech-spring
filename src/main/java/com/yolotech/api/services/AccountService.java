package com.yolotech.api.services;

import com.yolotech.api.entities.Account;
import com.yolotech.api.repositories.AccountRepository;
import com.yolotech.api.services.exceptions.ResourceNotFoundException;
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
    return optionalAccount.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public Account insert(Account account) {
    return accountRepository.save(account);
  }

  public void delete(Long id) {
    accountRepository.deleteById(id);
  }

  public Account update(Long id, Account account) {
    Account accountEntity = accountRepository.getOne(id);
    updateData(accountEntity, account);
    return accountRepository.save(accountEntity);
  }

  private void updateData(Account accountEntity, Account account) {
    accountEntity.setFullName(account.getFullName());
    accountEntity.setTitle(account.getTitle());
    accountEntity.setContato(account.getContato());
    accountEntity.setUsername(account.getUsername());
    accountEntity.setBio(account.getBio());
    accountEntity.setGithub(account.getGithub());
    accountEntity.setLinkedIn(account.getLinkedIn());
    accountEntity.setActive(account.isActive());
  }
}
