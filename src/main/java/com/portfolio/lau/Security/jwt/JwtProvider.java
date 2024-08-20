package com.portfolio.lau.Security.jwt;

import com.portfolio.lau.Security.Dto.MessageDto;
import com.portfolio.lau.Security.Entity.MainUser;
import io.jsonwebtoken.*;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;
    
    @Value("${jwt.expiration}")
    private int expiration;
    
    public String generateToken(Authentication authentication) {
        MainUser mainUser = (MainUser) authentication.getPrincipal();
        return Jwts.builder().setSubject(mainUser.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    
    public String getUserNameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            throw new MessageDto("Token mal formado");
        } catch (UnsupportedJwtException e) {
            throw new MessageDto("Token no soportado");
        } catch (ExpiredJwtException e) {
            throw new MessageDto("Token expirado");
        } catch (IllegalArgumentException e) {
            throw new MessageDto("Token vacío");
        } catch (SignatureException e) {
            throw new MessageDto("Firma inválida");
        }
    }

}