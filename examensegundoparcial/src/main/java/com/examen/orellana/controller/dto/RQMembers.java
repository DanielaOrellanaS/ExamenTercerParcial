package com.examen.orellana.controller.dto;

import java.io.Serializable;
import java.util.List;

import com.examen.orellana.model.Members;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RQMembers implements Serializable{
    private List<Members> members; 
}
