package com.example.apirestaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Restaurante {
    String nome;
    BigDecimal caixa;

    public Restaurante() {
        this.nome = "Restaurante";
        this.caixa = BigDecimal.valueOf(0);
    }
}
