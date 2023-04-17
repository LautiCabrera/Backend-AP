package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDto {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String descripcion;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
}
