package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Habilidades;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.lau.Repository.HabilidadesRepository;
import java.util.Optional;

@Service
public class ImplementHabilidadesService {
    
    @Autowired
    HabilidadesRepository habilidadesRepository;
    
    public List<Habilidades> list(){
        return habilidadesRepository.findAll();
    }
    
    public Optional<Habilidades> getOne(int id){
        return habilidadesRepository.findById(id);
    }
    
    public Optional<Habilidades> getByNombre(String nombre){
        return habilidadesRepository.findByNombre(nombre);
    }
    
    public void save(Habilidades habilidad){
        habilidadesRepository.save(habilidad);
    }
    
    public void delete(int id){
        habilidadesRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return habilidadesRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return habilidadesRepository.existsByNombre(nombre);
    }
}
