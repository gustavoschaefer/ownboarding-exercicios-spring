package com.example.gestaoclientes.controller;

import com.example.gestaoclientes.entity.Cliente;
import com.example.gestaoclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/salvar")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    @GetMapping("/buscar")
    public List<Cliente> buscar(@RequestParam Map<String,String> param) {
        return clienteService.buscar(param);
    }

//    @GetMapping("/buscar")
//    public Cliente buscar(@RequestParam Map<String,String> param) {
//        return clienteService.buscar(param);
//    }

}
