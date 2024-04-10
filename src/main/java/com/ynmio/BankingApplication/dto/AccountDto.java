package com.ynmio.BankingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class AccountDto {
    private int id;
    private String accountHolderName;
    private double balance;
}
