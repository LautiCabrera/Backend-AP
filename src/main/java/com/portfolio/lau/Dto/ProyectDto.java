package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
public class ProyectDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String duration;

    @NotBlank
    private String image;

    @NotBlank
    private String repo;

    @NotBlank
    private String demo;

}