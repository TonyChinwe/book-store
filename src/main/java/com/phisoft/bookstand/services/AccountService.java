package com.phisoft.bookstand.services;

import com.phisoft.bookstand.dtos.AccountDto;


/**
 * The service class that handles creating of user account in our book store
 */
public interface AccountService{

    /**
     * Creates and saves account in the repository
     * @param accountDto account data tranfer object
     * @return true if created successfully and false otherwise
     */
    public boolean saveAccount(AccountDto accountDto);


}
