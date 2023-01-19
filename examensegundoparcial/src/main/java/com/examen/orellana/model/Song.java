package com.examen.orellana.model;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    @Id 
    private String id; 
    
    private String title;
    
    private String album; 

    private Integer year; 

    private String singer; 

    private List<Members> members; 

    @Version
    private Long version; 
}
