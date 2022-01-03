package com.example.pratica1.dto;

import com.example.pratica1.entity.Casa;
import com.example.pratica1.entity.Comodo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CasaDTO {
    private String nome, endereco;
    private List<Comodo> comodoList;

    public static Casa toCasa(CasaDTO dto) {
        return Casa.builder().nome(dto.getNome()).endereco(dto.getEndereco()).comodoList(dto.getComodoList()).build();
    }
}
