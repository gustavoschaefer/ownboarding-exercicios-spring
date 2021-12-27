package com.example.apirestaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {
    public static Mesa builder;
    private long id;
    private List<Pedido> pedidos;
    private BigDecimal valorTotalConsumido;
}
