package com.examen.orellana.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RSSong implements Serializable{
    private String title; 
    
    private Integer year; 

    private String album; 

    private String singer; 
}
