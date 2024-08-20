package com.portfolio.lau.Security.Controller;

import com.portfolio.lau.Security.Dto.JwtDto;
import com.portfolio.lau.Security.Dto.MessageDto;
import com.portfolio.lau.Security.Dto.UserLogin;
import com.portfolio.lau.Security.Dto.NewUser;
import com.portfolio.lau.Security.Entity.Role;
import com.portfolio.lau.Security.Entity.User;
import com.portfolio.lau.Security.Service.RoleService;
import com.portfolio.lau.Security.Service.UserService;
import com.portfolio.lau.Security.jwt.JwtProvider;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new MessageDto("Campos inválidos"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity<>(new MessageDto("Nombre de usuario ingresado en uso"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity<>(new MessageDto("Email ingresado en uso"), HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .name(newUser.getName())
                .userName(newUser.getUserName())
                .email(newUser.getEmail())
                .password(passwordEncoder.encode(newUser.getPassword()))
                .build();

        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRole(com.portfolio.lau.Security.Enums.Role.ROLE_USER).get());

        if (newUser.getRoles().contains("admins")) {
            roles.add(roleService.getByRole(com.portfolio.lau.Security.Enums.Role.ROLE_ADMIN).get());
        }

        user.setRoles(roles);
        userService.save(user);

        return new ResponseEntity<>(new MessageDto("Usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLogin userLogin, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(new MessageDto("Campos incorrectos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }

}