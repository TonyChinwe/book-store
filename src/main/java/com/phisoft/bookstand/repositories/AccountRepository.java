package com.phisoft.bookstand.repositories;

import com.phisoft.bookstand.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Account repository
 */
public interface AccountRepository extends JpaRepository<Account,Long> {
    /**
     * Fetch account by username
     * @param username username
     * @return account
     */
    Optional<Account> getAccountByUsername(String username);

}
