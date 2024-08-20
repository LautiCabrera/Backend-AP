package com.portfolio.lau.Repository;

import com.portfolio.lau.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {

    Optional<Experience> findByName(String name);
    boolean existsByName(String name);

}