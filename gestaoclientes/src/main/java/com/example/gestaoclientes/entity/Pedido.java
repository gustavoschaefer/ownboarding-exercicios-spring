package com.example.gestaoclientes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Pedido {
    private static long idInc = 0;
    private long id;
    private List<Produto> produtoList;
    private BigDecimal valorTotal;

    public Pedido() {
        this.id = ++idInc;
    }


}
