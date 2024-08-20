package com.portfolio.lau.Repository;

import com.portfolio.lau.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer>{

    Optional<Education> findByName(String name);
    boolean existsByName(String name);

}