package com.ynmio.BankingApplication.controller;

import com.ynmio.BankingApplication.dto.AccountDto;
import com.ynmio.BankingApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(service.createAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> findAccountById(@PathVariable Integer id){
        AccountDto accountDto=service.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Integer id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=service.depositAmount(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Integer id, @RequestBody Map<String,Double> request){
        Double amount=request.get("amount");
        AccountDto accountDto=service.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        List<AccountDto> accounts=service.getAllAccount();
        return ResponseEntity.ok(accounts);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Integer id){
        service.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }
}
