package com.portfolio.lau.Security.Dto;

import java.util.Collection;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Getter @Setter
public class JwtDto {

    private String token;
    private String bearer = "Bearer";
    private String userName;
    private Collection <? extends GrantedAuthority > authorities;

    public JwtDto(String token, String userName, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.userName = userName;
        this.authorities = authorities;
    }

}