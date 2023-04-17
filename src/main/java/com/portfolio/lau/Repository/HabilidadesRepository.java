package com.portfolio.lau.Repository;

import com.portfolio.lau.Entity.Habilidades;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadesRepository extends JpaRepository<Habilidades, Integer> {
    public Optional<Habilidades> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
