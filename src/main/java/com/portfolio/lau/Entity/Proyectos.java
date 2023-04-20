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
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String descripcion; 
    
    private String url;

    public Proyectos() {
    }

    public Proyectos(String nombre, String descripcion, String url) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
    }

    
}
