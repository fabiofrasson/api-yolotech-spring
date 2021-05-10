package com.yolotech.api.resources;

import com.yolotech.api.entities.Account;
import com.yolotech.api.entities.Category;
import com.yolotech.api.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

  @PostMapping
  public ResponseEntity<Account> insert(@RequestBody Account account) {
    account = accountService.insert(account);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(account.getId()).toUri();
    return ResponseEntity.created(uri).body(account);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    accountService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Account> update(@PathVariable Long id, @RequestBody Account account) {
    account = accountService.update(id, account);
    return ResponseEntity.ok().body(account);
  }
}
