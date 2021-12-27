package com.example.apirestaurante.service;

import com.example.apirestaurante.entity.Pedido;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MesaService {
    public BigDecimal calculaValorTotalConsumido(List<Pedido> pedidos) {
        BigDecimal valorTotalConsumido = BigDecimal.valueOf(0);
        for (Pedido p : pedidos) {
            valorTotalConsumido.add(p.getValorTotal());
        }
        return valorTotalConsumido;
    }
}
