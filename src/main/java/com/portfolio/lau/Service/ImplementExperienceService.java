package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Experience;
import com.portfolio.lau.Repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ImplementExperienceService {
    
    @Autowired
    ExperienceRepository experienceRepository;
     
     public List<Experience> list(){
         return experienceRepository.findAll();
     }
     
     public Optional<Experience> getOne(int id){
         return experienceRepository.findById(id);
     }
     
     public Optional<Experience> getByName(String name){
         return experienceRepository.findByName(name);
     }

    @Transactional
     public void save(Experience experience){
         experienceRepository.save(experience);
     }

    @Transactional
     public void delete(int id){
         experienceRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return experienceRepository.existsById(id);
     }
     
     public boolean existsByName(String name){
         return experienceRepository.existsByName(name);
     }
    
}