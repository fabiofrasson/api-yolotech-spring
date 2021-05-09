package com.yolotech.api.resources;

import com.yolotech.api.entities.Account;
import com.yolotech.api.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/accounts")
public class AccountResource {

  @Autowired private AccountService accountService;

  @GetMapping
  public ResponseEntity<List<Account>> findAll() {
    List<Account> accounts = accountService.findAll();
    return ResponseEntity.ok().body(accounts);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Account> findById(@PathVariable Long id) {
    Account account = accountService.findById(id);
    return ResponseEntity.ok().body(account);
  }
}
