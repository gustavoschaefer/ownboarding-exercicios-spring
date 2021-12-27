package com.example.gestaoclientes.service;

import com.example.gestaoclientes.entity.Pedido;
import com.example.gestaoclientes.entity.Produto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PedidoService {

    public void calculaValorTotal(Pedido pedido) {
        BigDecimal valor = BigDecimal.valueOf(0);
        BigDecimal inc;
        for (Produto produto : pedido.getProdutoList()) {
            inc = produto.getPreco().multiply(BigDecimal.valueOf(produto.getQuantidade()));
            valor = valor.add(inc);
        }
        pedido.setValorTotal(valor);
    }
}
