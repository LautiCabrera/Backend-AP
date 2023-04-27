package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.ExperienciaDto;
import com.portfolio.lau.Entity.Experiencia;
import com.portfolio.lau.Service.ImplementExperienciaService;
import com.portfolio.lau.Security.Controller.Mensaje;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin(origins = {"https://frontend-ap-19794.web.app","http://localhost:4200"})
public class ExperienciaController {
    
    @Autowired
    ImplementExperienciaService implementExperienciaService;
    
    @GetMapping("lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = implementExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!implementExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia;
        experiencia = implementExperienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!implementExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        implementExperienciaService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("crear")
    public ResponseEntity<?> create(@RequestBody ExperienciaDto experienciaDto){      
        if(StringUtils.isBlank(experienciaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(implementExperienciaService.existsByNombre(experienciaDto.getNombre()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(experienciaDto.getNombre(), experienciaDto.getDescripcion(), experienciaDto.getDuracion(), experienciaDto.getImagen(), experienciaDto.getInfo());
        implementExperienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaDto dtoexp){
        if(!implementExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if(implementExperienciaService.existsByNombre(dtoexp.getNombre()) && implementExperienciaService.getByNombre(dtoexp.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = implementExperienciaService.getOne(id).get();
        experiencia.setNombre(dtoexp.getNombre());
        experiencia.setDescripcion((dtoexp.getDescripcion()));
        experiencia.setDuracion(dtoexp.getDuracion());
        experiencia.setInfo(dtoexp.getInfo());
        experiencia.setImagen(dtoexp.getImagen());
        
        implementExperienciaService.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
    
}
