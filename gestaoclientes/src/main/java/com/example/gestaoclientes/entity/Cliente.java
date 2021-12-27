package com.example.gestaoclientes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Cliente {
    private static long idInc = 0;
    private long id;
    private String nome, cpf, email, telefone;
    private List<Pedido> pedidoList;

    public Cliente() {
        this.id = ++idInc;
    }
}
