package com.portfolio.lau.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 5, max = 20, message = "No se cumple la condición")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 1500, message = "No se cumple la condición")
    private String descripcion; 
    
    public Educacion() {
        
    }

    public Educacion(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
}
