package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Skill;
import com.portfolio.lau.Repository.SkillRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ImplementSkillService {
    
    @Autowired
    SkillRepository skillRepository;
    
    public List<Skill> list(){
        return skillRepository.findAll();
    }
    
    public Optional<Skill> getOne(int id){
        return skillRepository.findById(id);
    }
    
    public Optional<Skill> getByName(String name){
        return skillRepository.findByName(name);
    }

    @Transactional
    public void save(Skill skill){
        skillRepository.save(skill);
    }

    @Transactional
    public void delete(int id){
        skillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skillRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return skillRepository.existsByName(name);
    }

}