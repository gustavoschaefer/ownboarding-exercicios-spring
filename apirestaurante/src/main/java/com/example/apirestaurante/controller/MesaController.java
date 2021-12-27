package com.example.apirestaurante.controller;

import com.example.apirestaurante.entity.Mesa;
import com.example.apirestaurante.entity.Restaurante;
import com.example.apirestaurante.service.MesaService;
import com.example.apirestaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @GetMapping
    public String sayHello() {
        return "Hello World";
    }

    @Autowired
    private MesaService mesaService;

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/salva")
    public Mesa salva(@RequestBody Mesa mesa) {
        return mesaService.salva(mesa);
    }

    @GetMapping("/{idMesa}")
    public Mesa getPedidosMesa(@PathVariable long idMesa) {
        return mesaService.buscaMesa(idMesa);
    }

    @GetMapping("/fecha/{idMesa}")
    public Restaurante fechaMesa(@PathVariable long idMesa) {
        return restauranteService.fecharMesa(idMesa);
    }


//    //listas de pratos dos pedidos
//    private List<Prato> pratos1 = Arrays.asList(
//            Prato.builder().id(1).descricao("Arroz").preco(BigDecimal.valueOf(15)).quantidade(1).build(),
//            Prato.builder().id(2).descricao("Feijão").preco(BigDecimal.valueOf(25)).quantidade(1).build(),
//            Prato.builder().id(3).descricao("Massa").preco(BigDecimal.valueOf(10)).quantidade(1).build()
//    );
//    private List<Prato> pratos2 = Arrays.asList(
//            Prato.builder().id(1).descricao("Sushi").preco(BigDecimal.valueOf(50)).quantidade(1).build()
//    );
//
//    //listas de pedidos das mesas
//    private List<Pedido> pedido1 = Arrays.asList(
////        Pedido.builder().idMesa(1).id(1).pratos(pratos1).valorTotal(pedidoService.calculaValorTotal(pratos1)).build()
//        Pedido.builder().idMesa(1).id(1).pratos(pratos1).build(),
//        Pedido.builder().idMesa(1).id(1).pratos(pratos2).build()
//    );
//    private List<Pedido> pedido2 = Arrays.asList(
////        Pedido.builder().idMesa(2).id(1).pratos(pratos2).valorTotal(pedidoService.calculaValorTotal(pratos2)).build()
//        Pedido.builder().idMesa(2).id(1).pratos(pratos2).build()
//    );
//
//    private List<Mesa> mesas = Arrays.asList(
////        Mesa.builder().id(1).pedidos(pedido1).valorTotalConsumido(mesaService.calculaValorTotalConsumido(pedido1)).build(),
////        Mesa.builder().id(2).pedidos(pedido2).valorTotalConsumido(mesaService.calculaValorTotalConsumido(pedido2)).build()
//        Mesa.builder().id(1).pedidos(pedido1).build(),
//        Mesa.builder().id(2).pedidos(pedido2).build()
//    );

//    @GetMapping("/fechar/{idMesa}")
//    public Restaurante fecharMesa(@PathVariable long idMesa) {
//        Optional<Mesa> optional = mesas.stream().filter(m -> m.getId()==idMesa).findFirst();
//        optional.get().setValorTotalConsumido(mesaService.calculaValorTotalConsumido(optional.get().getPedidos()));
//        List<Pedido> pedidos = optional.get().getPedidos();
//        pedidos.stream().forEach(pedido -> pedido.setValorTotal(pedidoService.calculaValorTotal(pedido.getPratos())));
//        return optional.orElse(new Mesa());
//    }

}
