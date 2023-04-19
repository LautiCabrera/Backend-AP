package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Proyectos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.lau.Repository.ProyectosRepository;

@Service
public class ImplementProyectosService{
    
    @Autowired
    ProyectosRepository proyectosRepository;
    
    public List<Proyectos> list(){
        return proyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return proyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombre(String nombre){
        return proyectosRepository.findByNombre(nombre);
    }
    
    public void save(Proyectos persona){
        proyectosRepository.save(persona);
    }
    
    public void delete(int id){
        proyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return proyectosRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return proyectosRepository.existsByNombre(nombre);
    }
    
}
