package com.examen.orellana.controller.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RSMembers implements Serializable{
    private List<String> members; 
}
