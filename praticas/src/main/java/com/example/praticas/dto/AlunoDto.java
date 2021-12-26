package com.example.praticas.dto;

import java.util.Map;

import com.example.praticas.entity.Aluno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {
    private String nome;
    private Map<String,Integer> notas;
    
    public static Aluno toAluno(AlunoDto dto) {
        return Aluno.builder().nome(dto.getNome()).notas(dto.getNotas()).build();
    }

    public static AlunoDto toAlunoDto(Aluno aluno) {
        return AlunoDto.builder().nome(aluno.getNome()).notas(aluno.getNotas()).build();
    }

}
