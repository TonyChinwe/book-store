package com.phisoft.bookstand.controllers;
import com.phisoft.bookstand.dtos.AccountDto;
import com.phisoft.bookstand.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/account")
@Api(value="account", description="Enables users to register with username and password.After which one can go to /login to login for access to our book store")
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(@Qualifier("account-impl-one") AccountService accountService){
        this.accountService=accountService;
    }

    @PostMapping("/register")
    @ApiOperation(value = "Registered a user and creates an account",notes = "This creates an account in the book store. Through the account, a user can upload books details and also view book's details")
    public String registerAccount(@Valid @RequestBody AccountDto accountDto)  {
        if(accountService.saveAccount(accountDto)){
            return "You have been registered successfully. You can then log in with your credentials";
        }else {
            return "Registration failed";
        }
    }
}
