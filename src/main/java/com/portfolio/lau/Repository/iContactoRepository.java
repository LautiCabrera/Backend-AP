package com.portfolio.lau.Repository;

import com.portfolio.lau.Entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iContactoRepository extends JpaRepository<Contacto,Integer> {
    
}
