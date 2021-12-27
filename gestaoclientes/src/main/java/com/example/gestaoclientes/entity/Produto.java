package com.example.gestaoclientes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Produto {
    private static long idInc = 0;
    private long id;
    private String descricao, cor;
    private int quantidade;
    private BigDecimal preco;

    public Produto() {
        this.id = ++idInc;
    }
}
