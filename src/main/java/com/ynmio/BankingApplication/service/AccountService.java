package com.ynmio.BankingApplication.service;

import com.ynmio.BankingApplication.dao.AccountRepository;
import com.ynmio.BankingApplication.dto.AccountDto;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Integer id);
    AccountDto depositAmount(Integer id,double amount);
    AccountDto withdraw(Integer id, double amount);
    List<AccountDto> getAllAccount();
    void deleteAccount(Integer id);
}
