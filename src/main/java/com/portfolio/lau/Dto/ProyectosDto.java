package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectosDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String url;

    public ProyectosDto() {
        
    }

    public ProyectosDto(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }
    
}
