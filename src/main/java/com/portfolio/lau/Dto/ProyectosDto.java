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
    private String desempenio;

    public ProyectosDto() {
    }

    public ProyectosDto(String nombre, String url, String desempenio) {
        this.nombre = nombre;
        this.url = url;
        this.desempenio = desempenio;
    }
    
}
