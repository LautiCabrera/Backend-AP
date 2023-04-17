package com.portfolio.lau.Entity;

import javax.persistence.Column;
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
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 3, max  = 30, message = "No llenó correctamente los campos")
    private String nombre;
    
    @NotNull
    @Size(min = 3, max  = 30, message = "No llenó correctamente los campos")
    private String apellido;
    
    @Column(length = 500)
    @NotNull
    private String descripcion;
    
    private String imagen;

    public Persona() {
        
    }

    public Persona(String nombre, String apellido, String descripcion, String imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        
        this.imagen = imagen;
    }
    
}