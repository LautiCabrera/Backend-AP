package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Education;
import com.portfolio.lau.Repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ImplementEducationService {
    
    @Autowired
    EducationRepository educationRepository;
    
    public List<Education> list(){
        return educationRepository.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return educationRepository.findById(id);
    }
    
    public Optional<Education> getByName(String name){
        return educationRepository.findByName(name);
    }

    @Transactional
    public void save(Education education){
        educationRepository.save(education);
    }
    @Transactional

    public void delete(int id){
        educationRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educationRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return educationRepository.existsByName(name);
    }
    
}