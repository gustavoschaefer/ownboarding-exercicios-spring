package com.example.pratica1.controller;

import com.example.pratica1.entity.Casa;
import com.example.pratica1.entity.Comodo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

@RestController
public class CasaController {

    private final static List<Casa> casas = Arrays.asList(
            Casa.builder().nome("Casa1").endereco("Rua1").comodoList(Arrays.asList(
                    Comodo.builder().nome("Quarto1").largura(3).comprimento(4).build(),
                    Comodo.builder().nome("Quarto2").largura(4).comprimento(4).build(),
                    Comodo.builder().nome("Cozinha").largura(6).comprimento(5).build(),
                    Comodo.builder().nome("Sala").largura(7).comprimento(5).build(),
                    Comodo.builder().nome("Banheiro").largura(2).comprimento(3).build()
            )).build(),
            Casa.builder().nome("Casa2").endereco("Rua1").comodoList(Arrays.asList(
                    Comodo.builder().nome("Quarto1").largura(3).comprimento(3).build(),
                    Comodo.builder().nome("Quarto2").largura(3).comprimento(2).build(),
                    Comodo.builder().nome("Cozinha").largura(4).comprimento(5).build(),
                    Comodo.builder().nome("Sala").largura(6).comprimento(3).build(),
                    Comodo.builder().nome("Banheiro").largura(2).comprimento(2).build()
            )).build()
    );

    @GetMapping("/casas")
    public List<Casa> getCasas() {
        return new ArrayList<>(casas);
    }

    @GetMapping(path = "/area/{nome}")
    public static float areaCasa(@PathVariable String nome) {
        float area = 0;
        for (Casa casa : casas) {
            if (casa.getNome().equals(nome)) {
                for (Comodo comodo : casa.getComodoList()) {
                    area += comodo.getComprimento() * comodo.getLargura();
                }
            }
        }
        return area;
    }

    @GetMapping(path = "/valor/{nome}")
    public static BigDecimal valorCasa(@PathVariable String nome) {
        float area = 0;
        for (Casa casa : casas) {
            if (casa.getNome().equals(nome)) {
                for (Comodo comodo : casa.getComodoList()) {
                    area += comodo.getComprimento() * comodo.getLargura();
                }
            }
        }
        return BigDecimal.valueOf(area * 800);
    }

    @GetMapping(path = "/maiorcomodo/{nome}")
    public static Comodo maiorComodo(@PathVariable String nome) {
        float area = 0;
        Comodo comodo = new Comodo();
        for (Casa casa : casas) {
            if (casa.getNome().equals(nome)) {
                for (Comodo c : casa.getComodoList()) {
                    if (area < c.getComprimento() * c.getLargura()) {
                        area = c.getComprimento() * c.getLargura();
                        comodo = c;
                    }
                }
            }
        }
        return comodo;
    }

    @GetMapping(path = "/areacomodos/{nome}")
    public static Map<String,Float> areaComodos(@PathVariable String nome) {
        Map<String,Float> comodos = new HashMap<>();
        for (Casa casa : casas) {
            if (casa.getNome().equals(nome)) {
                for (Comodo c : casa.getComodoList()) {
                     comodos.put(c.getNome(), c.getComprimento() * c.getLargura());
                }
            }
        }
        return comodos;
    }
}
