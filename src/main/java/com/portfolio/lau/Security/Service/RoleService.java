package com.portfolio.lau.Security.Service;

import com.portfolio.lau.Security.Entity.Role;
import com.portfolio.lau.Security.Repository.RoleRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;
    
    public Optional <Role> getByRole(com.portfolio.lau.Security.Enums.Role role){
        return roleRepository.findByRole(role);
    }
    
    public void save(Role role){
        roleRepository.save(role);
    }

}