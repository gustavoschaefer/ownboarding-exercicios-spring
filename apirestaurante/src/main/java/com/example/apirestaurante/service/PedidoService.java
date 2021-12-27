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
            valorTotal.add(p.getPreco());
        }
        return valorTotal;
    }


}
