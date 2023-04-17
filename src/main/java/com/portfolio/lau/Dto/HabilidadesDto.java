package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HabilidadesDto {
    
     @NotBlank
    private String nombre;
     
    @NotBlank
    private int progreso;

    public HabilidadesDto() {
    }

    public HabilidadesDto(String nombre, int progreso) {
        this.nombre = nombre;
        this.progreso = progreso;
    }
    
}
