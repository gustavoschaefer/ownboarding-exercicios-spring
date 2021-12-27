package com.example.gestaoclientes.service;

import com.example.gestaoclientes.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    List<Cliente> clienteList = new ArrayList<>();

    @Autowired
    PedidoService pedidoService;

    public Cliente salvar(Cliente cliente) {
        clienteList.add(cliente);
        cliente.getPedidoList().stream().forEach(pedido -> pedidoService.calculaValorTotal(pedido));
        return cliente;
    }

    public Cliente buscar(String nome) {
        for (Cliente cliente : clienteList) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> listar() {
        return clienteList;
    }
}
