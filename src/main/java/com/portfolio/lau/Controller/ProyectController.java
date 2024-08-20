package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.ProyectDto;
import com.portfolio.lau.Entity.Proyect;
import com.portfolio.lau.Security.Dto.MessageDto;
import com.portfolio.lau.Service.ImplementProyectService;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/proyect")
public class ProyectController {

    @Autowired
    ImplementProyectService implementProyectService;

    @GetMapping
    public ResponseEntity<List<Proyect>> list() {
        List<Proyect> list = implementProyectService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!implementProyectService.existsById(id)) {
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Proyect proyect = implementProyectService.getOne(id).get();
        return new ResponseEntity<>(proyect, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!implementProyectService.existsById(id)) {
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        implementProyectService.delete(id);
        return new ResponseEntity<>(new MessageDto("Proyecto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProyectDto proyectDto) {
        if (StringUtils.isBlank(proyectDto.getName()))
            return new ResponseEntity<>(new MessageDto("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (implementProyectService.existsByNombre(proyectDto.getName()))
            return new ResponseEntity<>(new MessageDto("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Proyect proyect = Proyect.builder()
                .name(proyectDto.getName())
                .description(proyectDto.getDescription())
                .duration(proyectDto.getDuration())
                .image(proyectDto.getImage())
                .repo(proyectDto.getRepo())
                .demo(proyectDto.getDemo())
                .build();

        implementProyectService.save(proyect);

        return new ResponseEntity<>(new MessageDto("Proyecto creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProyectDto proyectdto) {
        if (!implementProyectService.existsById(id))
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.NOT_FOUND);
        if (implementProyectService.existsByNombre(proyectdto.getName())
                && implementProyectService.getByNombre(proyectdto.getName()).get().getId() != id)
            return new ResponseEntity<>(new MessageDto("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(proyectdto.getName()))
            return new ResponseEntity<>(new MessageDto("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);

        Proyect proyect = implementProyectService.getOne(id).get();
        proyect.setName(proyectdto.getName());
        proyect.setDescription(proyectdto.getDescription());
        proyect.setDuration(proyectdto.getDuration());
        proyect.setImage(proyectdto.getImage());
        proyect.setRepo(proyectdto.getRepo());
        proyect.setDemo(proyect.getDemo());

        implementProyectService.save(proyect);

        return new ResponseEntity<>(new MessageDto("Proyecto actualizado"), HttpStatus.OK);
    }

}