package com.example.apirestaurante.controller;

import com.example.apirestaurante.entity.Mesa;
import com.example.apirestaurante.entity.Pedido;
import com.example.apirestaurante.entity.Prato;
import com.example.apirestaurante.service.MesaService;
import com.example.apirestaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mesa")
public class MesaController {

//    @GetMapping("/ping")
//    public String meuMetodo() {
//        return "pong";
//    }

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private MesaService mesaService;

    //listas de pratos dos pedidos
    private final List<Prato> pratos1 = Arrays.asList(
            Prato.builder().id(1).descricao("Arroz").preco(BigDecimal.valueOf(15)).quantidade(1).build(),
            Prato.builder().id(2).descricao("Feijão").preco(BigDecimal.valueOf(25)).quantidade(1).build(),
            Prato.builder().id(3).descricao("Massa").preco(BigDecimal.valueOf(10)).quantidade(1).build()
    );
    private final List<Prato> pratos2 = Arrays.asList(
            Prato.builder().id(1).descricao("Sushi").preco(BigDecimal.valueOf(50)).quantidade(1).build()
    );

    //listas de pedidos das mesas
    private final List<Pedido> pedido1 = Arrays.asList(
            Pedido.builder().idMesa(1).id(1).pratos(pratos1).valorTotal(pedidoService.calculaValorTotal(pratos1)).build()
    );
    private final List<Pedido> pedido2 = Arrays.asList(
            Pedido.builder().idMesa(2).id(1).pratos(pratos2).build()
    );

    private final List<Mesa> mesas = Arrays.asList(
            Mesa.builder().id(1).pedidos(pedido1).valorTotalConsumido(mesaService.calculaValorTotalConsumido(pedido1)).build(),
            Mesa.builder().id(2).pedidos(pedido2).valorTotalConsumido(mesaService.calculaValorTotalConsumido(pedido2)).build()
    );

    @GetMapping("/{idMesa}")
    public Mesa getPedidosMesa(@PathVariable long idMesa) {
        Optional<Mesa> optional = mesas.stream().filter(m -> m.getId()==idMesa).findFirst();
        return optional.orElse(new Mesa());
    }

}
