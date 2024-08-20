package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.EducationDto;
import com.portfolio.lau.Entity.Education;
import com.portfolio.lau.Security.Dto.MessageDto;
import com.portfolio.lau.Service.ImplementEducationService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/education")
public class EducationController {

    @Autowired
    ImplementEducationService implementEducationService;

    @GetMapping
    public ResponseEntity<List<Education>> list() {
        List<Education> list = implementEducationService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!implementEducationService.existsById(id)) {
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Education education = implementEducationService.getOne(id).get();
        return new ResponseEntity<>(education, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!implementEducationService.existsById(id)) {
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        implementEducationService.delete(id);
        return new ResponseEntity<>(new MessageDto("Educación eliminada"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDto educationDto) {
        if (StringUtils.isBlank(educationDto.getName()))
            return new ResponseEntity<>(new MessageDto("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (implementEducationService.existsByName(educationDto.getName()))
            return new ResponseEntity<>(new MessageDto("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        Education education = Education.builder()
                .name(educationDto.getName())
                .description(educationDto.getDescription())
                .duration(educationDto.getDuration())
                .image(educationDto.getImage())
                .info(educationDto.getInfo())
                .build();

        implementEducationService.save(education);

        return new ResponseEntity<>(new MessageDto("Educación creada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDto educaciondto) {
        if (!implementEducationService.existsById(id))
            return new ResponseEntity<>(new MessageDto("No existe el ID"), HttpStatus.NOT_FOUND);
        if (implementEducationService.existsByName(educaciondto.getName())
                && implementEducationService.getByName(educaciondto.getName()).get().getId() != id)
            return new ResponseEntity<>(new MessageDto("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(educaciondto.getName()))
            return new ResponseEntity<>(new MessageDto("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);

        Education education = implementEducationService.getOne(id).get();
        education.setName(educaciondto.getName());
        education.setDescription(educaciondto.getDescription());
        education.setDuration(educaciondto.getDuration());
        education.setImage(educaciondto.getImage());
        education.setInfo(educaciondto.getInfo());

        implementEducationService.save(education);

        return new ResponseEntity<>(new MessageDto("Educación actualizada"), HttpStatus.OK);
    }

}