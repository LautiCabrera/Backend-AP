package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectosDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String url;
    @NotBlank
    private String descripcion;

    public ProyectosDto() {
        
    }

    public ProyectosDto(String nombre, String url, String descripcion) {
        this.nombre = nombre;
        this.url = url;
        this.descripcion = descripcion;
    }
    
}
