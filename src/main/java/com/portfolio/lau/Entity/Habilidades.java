package com.portfolio.lau.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Getter @Setter
@Entity
public class Habilidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int progreso;

    public Habilidades() {
        
    }
    
    public Habilidades(String nombre, int progreso) {
        this.nombre = nombre;
        this.progreso = progreso;
    }
    
    
    
}
