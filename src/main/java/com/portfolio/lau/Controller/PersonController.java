package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.PersonDto;
import com.portfolio.lau.Entity.Person;
import com.portfolio.lau.Security.Dto.MessageDto;
import com.portfolio.lau.Service.ImplementPersonService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    ImplementPersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> list() {
        List<Person> list = personService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!personService.existsById(id)) {
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Person person = personService.getOne(id).get();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody PersonDto dtopersona) {
        if (!personService.existsById(id))
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.NOT_FOUND);
        if (personService.existsByName(dtopersona.getName())
                && personService.getByName(dtopersona.getName()).get().getId() != id)
            return new ResponseEntity<>(new MessageDto("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtopersona.getName()))
            return new ResponseEntity<>(new MessageDto("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);

        Person person = personService.getOne(id).get();

        person.setName(dtopersona.getName());
        person.setLastname(dtopersona.getLastname());
        person.setDescription(dtopersona.getDescription());
        person.setImage(dtopersona.getImage());
        person.setTitle(dtopersona.getTitle());

        personService.save(person);

        return new ResponseEntity<>(new MessageDto("Persona actualizada"), HttpStatus.OK);
    }

}