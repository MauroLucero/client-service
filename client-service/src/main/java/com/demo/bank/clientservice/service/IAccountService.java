package com.demo.bank.clientservice.service;

import com.demo.bank.clientservice.model.AccountDTO;

import java.util.Set;

public interface IAccountService {
    void addAccount(AccountDTO accountDTO);

    AccountDTO findAccount(Long id);

    Set<AccountDTO> getAllAccounts();

    void updateAccount(AccountDTO accountDTO);

    void deleteAccount(Long id);


}
