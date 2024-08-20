package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Proyect;
import com.portfolio.lau.Repository.ProyectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class ImplementProyectService {
    
    @Autowired
    ProyectRepository proyectRepository;
    
    public List<Proyect> list(){
        return proyectRepository.findAll();
    }
    
    public Optional<Proyect> getOne(int id){
        return proyectRepository.findById(id);
    }
    
    public Optional<Proyect> getByNombre(String name){
        return proyectRepository.findByName(name);
    }

    @Transactional
    public void save(Proyect proyect){
        proyectRepository.save(proyect);
    }

    @Transactional
    public void delete(int id){
        proyectRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectRepository.existsById(id);
    }
    
    public boolean existsByNombre(String name){
        return proyectRepository.existsByName(name);
    }
    
}