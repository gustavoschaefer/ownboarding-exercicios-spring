package com.example.apirestaurante.service;

import com.example.apirestaurante.entity.Prato;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    public BigDecimal calculaValorTotal(List<Prato> pratos) {
        BigDecimal valorTotal = BigDecimal.valueOf(0);
        for (Prato p : pratos) {
            BigDecimal valor = p.getPreco().multiply(BigDecimal.valueOf(p.getQuantidade()));
            valorTotal = valorTotal.add(valor);
        }
        return valorTotal;
    }


}
