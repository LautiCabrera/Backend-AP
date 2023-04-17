package com.portfolio.lau.Service;

import com.portfolio.lau.Entity.Experiencia;
import com.portfolio.lau.Repository.ExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImplementExperienciaService {
    
    @Autowired
    ExperienciaRepository experienciaRepository;
     
     public List<Experiencia> list(){
         return experienciaRepository.findAll();
     }
     
     public Optional<Experiencia> getOne(int id){
         return experienciaRepository.findById(id);
     }
     
     public Optional<Experiencia> getByNombre(String nombre){
         return experienciaRepository.findByNombre(nombre);
     }
     
     public void save(Experiencia experiencia){
         experienciaRepository.save(experiencia);
     }
     
     public void delete(int id){
         experienciaRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return experienciaRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return experienciaRepository.existsByNombre(nombre);
     }
    
}
