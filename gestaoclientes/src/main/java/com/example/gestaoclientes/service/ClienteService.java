package com.example.gestaoclientes.service;

import com.example.gestaoclientes.controller.repository.ClienteRepository;
import com.example.gestaoclientes.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ClienteService {

    //List<Cliente> clienteList = new ArrayList<>();

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    PedidoService pedidoService;

    public Cliente salvar(Cliente cliente) {
        //clienteList.add(cliente);
        cliente.getPedidoList().stream().forEach(pedido -> pedidoService.calculaValorTotal(pedido));
        try {
            clienteRepository.save(cliente);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public List<Cliente> listar() {
        //return clienteList;
        try {
            return clienteRepository.list();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Cliente> buscar(Map<String,String> param) {
//        for (Cliente cliente : clienteList) {
//            if (cliente.getNome().equals(nome)) {
//                return cliente;
//            }
//        }
//        return null;
        try {
            return clienteRepository.get(param);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
