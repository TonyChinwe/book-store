package com.phisoft.bookstand.dtos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    @NotBlank(message = "The username must not be blank")
    @NotNull(message = "You must enter a username")
    @Length(min = 4,message = "The length of username must be more than four")
    private String username;
    @NotBlank(message = "The password must not be blank")
    @NotNull(message = "You must enter a password")
    @Length(min = 4,message = "The length of password must be more than four")
    private String password;

}
