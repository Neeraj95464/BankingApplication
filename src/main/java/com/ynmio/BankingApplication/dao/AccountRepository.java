package com.ynmio.BankingApplication.dao;

import com.ynmio.BankingApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
