package com.portfolio.lau.Entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 3, max  = 30, message = "No llenó correctamente los campos")
    private String name;
    
    @NotNull
    @Size(min = 3, max  = 30, message = "No llenó correctamente los campos")
    private String lastname;
    
    @Column(length = 500)
    @NotNull
    private String description;
    
    private String image;
    
    @NotNull
    @Size(min = 3, max  = 40, message = "No llenó correctamente los campos")
    private String title;
    
}