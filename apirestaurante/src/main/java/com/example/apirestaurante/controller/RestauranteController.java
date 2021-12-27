package com.example.apirestaurante.controller;

import com.example.apirestaurante.entity.Restaurante;
import com.example.apirestaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/caixa")
    public Restaurante getCaixa() {
        return restauranteService.saldoCaixa();
    }
}
