package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Person;
import com.portfolio.lau.Repository.PersonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ImplementPersonService {

    @Autowired
    PersonRepository personRepository;
    
    public List<Person> list(){
        return personRepository.findAll();
    }
    
    public Optional<Person> getOne(int id){
        return personRepository.findById(id);
    }
    
    public Optional<Person> getByName(String name){
        return personRepository.findByName(name);
    }

    @Transactional
    public void save(Person person){
        personRepository.save(person);
    }

    @Transactional
    public void delete(int id){
        personRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return personRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return personRepository.existsByName(name);
    }
    
}