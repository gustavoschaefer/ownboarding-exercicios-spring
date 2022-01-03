package com.example.pratica1.dto;

import com.example.pratica1.entity.Aluno;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    @NotNull
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 8, max = 50, message = "O nome do aluno deve ter de 8 a 50 caracteres.")
    private String nome;
    private Map<@Size(min = 8, max = 50, message = "O nome da disciplina deve ter de 8 a 50 caracteres.") String
            ,@Size(min = 1, max = 2, message = "A nota da disciplina deve ter de 1 a 2 caracteres.") String> notas;
    
    public static Aluno toAluno(AlunoDTO dto) {
        return Aluno.builder().nome(dto.getNome()).notas(dto.getNotas()).build();
    }

    public static AlunoDTO toAlunoDto(Aluno aluno) {
        return AlunoDTO.builder().nome(aluno.getNome()).notas(aluno.getNotas()).build();
    }

}
