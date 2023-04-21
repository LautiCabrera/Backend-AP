package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.ProyectosDto;
import com.portfolio.lau.Entity.Proyectos;
import com.portfolio.lau.Security.Controller.Mensaje;
import com.portfolio.lau.Service.ImplementProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200/")
public class ProyectosController {
    
    @Autowired
    ImplementProyectosService implementProyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = implementProyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detalle/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")int id){
        if(!implementProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = implementProyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!implementProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        implementProyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody ProyectosDto proyectosDto){
        if(StringUtils.isBlank(proyectosDto.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(implementProyectosService.existsByNombre(proyectosDto.getNombre()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Proyectos proyectos = new Proyectos(proyectosDto.getNombre(), proyectosDto.getDescripcion(),proyectosDto.getUrl());
        implementProyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectosDto proyectosdto){
        if(!implementProyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        if(implementProyectosService.existsByNombre(proyectosdto.getNombre()) && implementProyectosService.getByNombre(proyectosdto.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(proyectosdto.getNombre()))
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyectos = implementProyectosService.getOne(id).get();
        proyectos.setNombre(proyectosdto.getNombre());
        proyectos.setDescripcion(proyectosdto.getDescripcion());
        proyectos.setUrl(proyectosdto.getUrl());
        
        implementProyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
   
}
