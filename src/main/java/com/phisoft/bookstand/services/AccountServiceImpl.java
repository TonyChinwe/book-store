package com.phisoft.bookstand.services;

import com.phisoft.bookstand.authentication.Role;
import com.phisoft.bookstand.dtos.AccountDto;
import com.phisoft.bookstand.models.Account;
import com.phisoft.bookstand.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}
 */

@Service
@Qualifier("account-impl-one")
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,PasswordEncoder passwordEncoder){
      this.accountRepository=accountRepository;
      this.passwordEncoder=passwordEncoder;

    }

    /**
     * {@inheritDoc}
     */

    @Override
    public boolean saveAccount(AccountDto accountDto) {
        Account account=new Account();
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        account.setUsername(accountDto.getUsername());
        account.setEnabled(true);
        account.setNotExpired(true);
        account.setNotLocked(true);
        account.setCredentialNotExpired(true);
        if(accountDto.getUsername().substring(0,3).equalsIgnoreCase("c#p")){
           account.setRole(Role.ADMIN);
        }else{
            account.setRole(Role.MANAGER);
        }
        Account acc=accountRepository.getAccountByUsername(accountDto.getUsername()).orElse(null);
        if(acc==null){
            accountRepository.save(account);
            return true;
        }
        return false;
    }
}
