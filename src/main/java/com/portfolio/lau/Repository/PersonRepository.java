package com.portfolio.lau.Repository;

import com.portfolio.lau.Entity.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer> {

    Optional<Person> findByName(String name);
    boolean existsByName(String name);

}