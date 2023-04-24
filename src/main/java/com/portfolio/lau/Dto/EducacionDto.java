package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducacionDto {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String duracion;
    
    @NotBlank
    private String imagen;
    
    @NotBlank
    private String info;
    
    public EducacionDto() {
    }

    public EducacionDto(String nombre, String descripcion, String duracion, String imagen, String info) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.imagen = imagen;
        this.info= info;
    }
    
}
