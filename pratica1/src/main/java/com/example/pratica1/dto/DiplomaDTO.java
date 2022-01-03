package com.example.pratica1.dto;

import com.example.pratica1.entity.Diploma;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiplomaDTO {
    @NotNull
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 8, max = 50, message = "tamanho minimo 3")
    private String msg, nome;
    private float media;

    public static Diploma toDiploma(DiplomaDTO dto) {
        return Diploma.builder().nome(dto.getNome()).msg(dto.getMsg()).media(dto.getMedia()).build();
    }

    public static DiplomaDTO toDiplomaDto(Diploma diploma) {
        return DiplomaDTO.builder().nome(diploma.getNome()).msg(diploma.getMsg()).media(diploma.getMedia()).build();
    }
}
