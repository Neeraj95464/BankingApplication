package com.ynmio.BankingApplication.mapper;

import com.ynmio.BankingApplication.dto.AccountDto;
import com.ynmio.BankingApplication.model.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account=new Account(
          accountDto.getId(),
          accountDto.getAccountHolderName(),
          accountDto.getBalance()
        );
        return account;
    }
    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountDto;
    }
}
