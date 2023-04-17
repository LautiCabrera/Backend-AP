package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.HabilidadesDto;
import com.portfolio.lau.Entity.Habilidades;
import com.portfolio.lau.Security.Controller.Mensaje;
import com.portfolio.lau.Service.ImplementHabilidadesService;
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
@RequestMapping("/habilidades")
@CrossOrigin(origins="http://localhost:4200/")
public class HabilidadesController {
    
    @Autowired
    ImplementHabilidadesService serviceHabilidades;

    @GetMapping("/lista")
    public ResponseEntity<List<Habilidades>> list() {
        List<Habilidades> list = serviceHabilidades.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Habilidades> getById(@PathVariable("id") int id) {
        if (!serviceHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Habilidades hYs = serviceHabilidades.getOne(id).get();
        return new ResponseEntity(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!serviceHabilidades.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        serviceHabilidades.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody HabilidadesDto habilidadesDto) {
        if(StringUtils.isBlank(habilidadesDto.getNombre())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(serviceHabilidades.existsByNombre(habilidadesDto.getNombre())) 
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        Habilidades habilidades = new Habilidades(habilidadesDto.getNombre(), habilidadesDto.getProgreso());
        serviceHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody HabilidadesDto dtohys) {
        if (!serviceHabilidades.existsById(id)) 
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        if (serviceHabilidades.existsByNombre(dtohys.getNombre()) && serviceHabilidades.getByNombre(dtohys.getNombre()).get().getId() != id) 
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtohys.getNombre())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        Habilidades habilidades = serviceHabilidades.getOne(id).get();
        habilidades.setNombre(dtohys.getNombre());
        habilidades.setProgreso(dtohys.getProgreso());

        serviceHabilidades.save(habilidades);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);

    }
    
}
