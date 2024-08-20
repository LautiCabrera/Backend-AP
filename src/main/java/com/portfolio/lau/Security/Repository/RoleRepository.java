package com.portfolio.lau.Security.Repository;

import com.portfolio.lau.Security.Entity.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Integer> {

    Optional <Role> findByRole(com.portfolio.lau.Security.Enums.Role role);

}