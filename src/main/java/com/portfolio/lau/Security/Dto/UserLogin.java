package com.portfolio.lau.Security.Dto;

import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
public class UserLogin {
    
    @NotBlank
    private String userName;
    @NotBlank
    private String password;

}