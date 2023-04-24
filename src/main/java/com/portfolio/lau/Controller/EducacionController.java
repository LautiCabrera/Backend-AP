package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.EducacionDto;
import com.portfolio.lau.Entity.Educacion;
import com.portfolio.lau.Security.Controller.Mensaje;
import com.portfolio.lau.Service.ImplementEducacionService;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200/")
public class EducacionController {
    
    @Autowired
    ImplementEducacionService implementEducacionService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = implementEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id")int id){
        if(!implementEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = implementEducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!implementEducacionService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        implementEducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
        if(StringUtils.isBlank(educacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(implementEducacionService.existsByNombre(educacionDto.getNombre()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(educacionDto.getNombre(), educacionDto.getDescripcion(), educacionDto.getDuracion(), educacionDto.getImagen(), educacionDto.getInfo());
        implementEducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educación creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducacionDto educaciondto){
        if(!implementEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        if(implementEducacionService.existsByNombre(educaciondto.getNombre()) && implementEducacionService.getByNombre(educaciondto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educaciondto.getNombre()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = implementEducacionService.getOne(id).get();
        educacion.setNombre(educaciondto.getNombre());
        educacion.setDescripcion(educaciondto.getDescripcion());
        educacion.setDuracion(educaciondto.getDuracion());
        educacion.setImagen(educaciondto.getImagen());
        educacion.setInfo(educaciondto.getInfo());
        
        implementEducacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
    
}
