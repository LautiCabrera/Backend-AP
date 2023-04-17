package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Educacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.lau.Repository.EducacionRepository;
import java.util.Optional;

@Service
public class ImplementEducacionService {
    
    @Autowired EducacionRepository educacionRepository;
    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return educacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByNombre(String nombre){
        return educacionRepository.findByNombre(nombre);
    }
    
    public void save(Educacion educacion){
        educacionRepository.save(educacion);
    }
    
    public void delete(int id){
        educacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return educacionRepository.existsByNombre(nombre);
    }
    
}
