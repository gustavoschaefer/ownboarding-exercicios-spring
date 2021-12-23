package com.example.praticas.entity;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    int matricula;
    String nome;
    Map<String,Integer> notas;
    
}
