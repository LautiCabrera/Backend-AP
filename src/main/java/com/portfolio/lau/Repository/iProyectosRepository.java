package com.portfolio.lau.Repository;

import com.portfolio.lau.Entity.Proyectos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iProyectosRepository extends JpaRepository<Proyectos,Integer> {
    
    
    
}
