package com.portfolio.lau.Dto;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Getter @Setter
public class SkillDto {
    
     @NotBlank
    private String name;
     
    @NotBlank
    private String icon;

}