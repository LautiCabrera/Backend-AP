package com.portfolio.lau.Controller;

import com.portfolio.lau.Dto.SkillDto;
import com.portfolio.lau.Entity.Skill;
import com.portfolio.lau.Security.Dto.MessageDto;
import com.portfolio.lau.Service.ImplementSkillService;
import java.util.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    ImplementSkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = skillService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id) {
        if (!skillService.existsById(id))
            return new ResponseEntity<>(new MessageDto("no existe"), HttpStatus.NOT_FOUND);
        Skill hYs = skillService.getOne(id).get();
        return new ResponseEntity<>(hYs, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillService.existsById(id)) {
            return new ResponseEntity<>(new MessageDto("no existe"), HttpStatus.NOT_FOUND);
        }
        skillService.delete(id);
        return new ResponseEntity<>(new MessageDto("Skill eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getName()))
            return new ResponseEntity<>(new MessageDto("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if (skillService.existsByName(skillDto.getName()))
            return new ResponseEntity<>(new MessageDto("Esa skill ya existe"), HttpStatus.BAD_REQUEST);

        Skill skill = Skill.builder()
                .name(skillDto.getName())
                .icon(skillDto.getIcon())
                .build();

        skillService.save(skill);

        return new ResponseEntity<>(new MessageDto("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillDto dtohys) {
        if (!skillService.existsById(id))
            return new ResponseEntity<>(new MessageDto("El ID no existe"), HttpStatus.BAD_REQUEST);
        if (skillService.existsByName(dtohys.getName())
                && skillService.getByName(dtohys.getName()).get().getId() != id)
            return new ResponseEntity<>(new MessageDto("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        if (StringUtils.isBlank(dtohys.getName()))
            return new ResponseEntity<>(new MessageDto("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        Skill skill = skillService.getOne(id).get();
        skill.setName(dtohys.getName());
        skill.setIcon(dtohys.getIcon());

        skillService.save(skill);
        return new ResponseEntity<>(new MessageDto("Skill actualizada"), HttpStatus.OK);
    }

}