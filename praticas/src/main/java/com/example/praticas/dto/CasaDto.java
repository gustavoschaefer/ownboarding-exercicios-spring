package com.example.praticas.dto;

import com.example.praticas.entity.Casa;
import com.example.praticas.entity.Comodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CasaDto {
    private String nome, endereco;
    private List<Comodo> comodoList;

    public static Casa toCasa(CasaDto dto) {
        return Casa.builder().nome(dto.getNome()).endereco(dto.getEndereco()).comodoList(dto.getComodoList()).build();
    }
}
