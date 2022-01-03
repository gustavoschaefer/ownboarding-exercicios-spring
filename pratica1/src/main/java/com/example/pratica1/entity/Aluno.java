package com.example.pratica1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    int matricula;
    String nome;
    Map<String,String> notas;
    
}
