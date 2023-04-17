
package com.portfolio.lau.Security.Repository;

import com.portfolio.lau.Security.Entity.Rol;
import com.portfolio.lau.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository <Rol, Integer> {
    Optional <Rol> findByRolNombre(RolNombre rolNombre);
}
