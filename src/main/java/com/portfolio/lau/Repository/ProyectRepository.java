package com.portfolio.lau.Repository;

import com.portfolio.lau.Entity.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectRepository extends JpaRepository<Proyect, Integer> {

    Optional<Proyect> findByName(String name);
    boolean existsByName(String name);

}