package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDto {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String imagen;
    @NotBlank
    private String titulo;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String descripcion, String imagen, String titulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.titulo = titulo;
    }
    
}
