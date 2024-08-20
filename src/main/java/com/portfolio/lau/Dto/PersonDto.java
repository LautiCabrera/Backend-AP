package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
public class PersonDto {
    
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    @NotBlank
    private String description;
    @NotBlank
    private String image;
    @NotBlank
    private String title;

}