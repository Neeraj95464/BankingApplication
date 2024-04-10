package com.ynmio.BankingApplication.service.impl;

import com.ynmio.BankingApplication.dao.AccountRepository;
import com.ynmio.BankingApplication.dto.AccountDto;
import com.ynmio.BankingApplication.mapper.AccountMapper;
import com.ynmio.BankingApplication.model.Account;
import com.ynmio.BankingApplication.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Integer id) {
        Account account=accountRepository.findById(id).
                orElseThrow(()->new RuntimeException("Account Could not find"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Integer id, double amount) {
        Account account=accountRepository.findById(id).
                orElseThrow(()->new RuntimeException("Account Could not find"));
        double totalAmount = account.getBalance()+amount;
        account.setBalance(totalAmount);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Integer id, double amount) {
        Account account=accountRepository.findById(id).
                orElseThrow(()->new RuntimeException("Account Could not find"));
        if(account.getBalance()<amount){
            throw new RuntimeException("Insufficient Balance ");
        }
        double totalAmount = account.getBalance() - amount;
        account.setBalance(totalAmount);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().map((account) ->AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Integer id) {
        Account account=accountRepository.findById(id).
                orElseThrow(()->new RuntimeException("Account Could not find"));
        accountRepository.deleteById(id);
    }

}
