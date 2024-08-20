package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.ExperienceDto;
import com.portfolio.lau.Entity.Experience;
import com.portfolio.lau.Service.ImplementExperienceService;
import com.portfolio.lau.Security.Dto.MessageDto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/experience")
public class ExperienceController {

    @Autowired
    ImplementExperienceService implementExperienceService;

    @GetMapping
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = implementExperienceService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!implementExperienceService.existsById(id))
            return new ResponseEntity<>(new MessageDto("no existe"), HttpStatus.NOT_FOUND);
        Experience experience;
        experience = implementExperienceService.getOne(id).get();
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!implementExperienceService.existsById(id)) {
            return new ResponseEntity<>(new MessageDto("no existe"), HttpStatus.NOT_FOUND);
        }
        implementExperienceService.delete(id);
        return new ResponseEntity<>(new MessageDto("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ExperienceDto experienceDto) {
        if (StringUtils.isBlank(experienceDto.getName()))
            return new ResponseEntity<>(new MessageDto("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (implementExperienceService.existsByName(experienceDto.getName()))
            return new ResponseEntity<>(new MessageDto("Esa experiencia existe"), HttpStatus.BAD_REQUEST);

        Experience experience = Experience.builder()
                .name(experienceDto.getName())
                .description(experienceDto.getDescription())
                .duration(experienceDto.getDuration())
                .image(experienceDto.getImage())
                .info(experienceDto.getInfo())
                .build();

        implementExperienceService.save(experience);

        return new ResponseEntity<>(new MessageDto("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienceDto dtoexp) {
        if (!implementExperienceService.existsById(id))
            return new ResponseEntity<>(new MessageDto("El ID no existe"), HttpStatus.BAD_REQUEST);
        if (implementExperienceService.existsByName(dtoexp.getName())
                && implementExperienceService.getByName(dtoexp.getName()).get().getId() != id)
            return new ResponseEntity<>(new MessageDto("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtoexp.getName()))
            return new ResponseEntity<>(new MessageDto("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Experience experience = implementExperienceService.getOne(id).get();
        experience.setName(dtoexp.getName());
        experience.setDescription((dtoexp.getDescription()));
        experience.setDuration(dtoexp.getDuration());
        experience.setInfo(dtoexp.getInfo());
        experience.setImage(dtoexp.getImage());

        implementExperienceService.save(experience);
        return new ResponseEntity<>(new MessageDto("Experiencia actualizada"), HttpStatus.OK);
    }

}