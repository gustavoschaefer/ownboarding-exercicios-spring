package com.example.apirestaurante.service;

import com.example.apirestaurante.entity.Mesa;
import com.example.apirestaurante.entity.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RestauranteService {

    Restaurante restaurante = new Restaurante();

    @Autowired
    private MesaService mesaService;

    public Restaurante fecharMesa(long idMesa) {
        Mesa mesa = mesaService.buscaMesa(idMesa);
        restaurante.setCaixa(restaurante.getCaixa().add(mesa.getValorTotalConsumido()));
        mesaService.mesaList.removeIf(m -> m.getId() == idMesa);
        return restaurante;
    }

    public Restaurante saldoCaixa() {
        return restaurante;
    }
}
