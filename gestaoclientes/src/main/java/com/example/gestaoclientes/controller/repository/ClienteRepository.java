package com.example.gestaoclientes.controller.repository;

import com.example.gestaoclientes.entity.Cliente;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ClienteRepository implements Repository<Cliente, Map<String,String>> {

    private List<Cliente> clientes = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String PATH = "src/main/java/com/example/gestaoclientes/files/clientes.json";

    @Override
    public void save(Cliente cliente) throws IOException {
        try {
            clientes = objectMapper.readValue(new File(PATH), new TypeReference<ArrayList<Cliente>>(){});
        } catch (MismatchedInputException e) {}
        cliente.setId((long)clientes.size() + 1);
        clientes.add(cliente);
        objectMapper.writeValue(new File(PATH), clientes);
    }

    @Override
    public List<Cliente> list() throws IOException {
//        File file = new File(PATH);
//        FileInputStream fileInputStream = new FileInputStream(file);
//        clientes = Arrays.asList(objectMapper.readValue(fileInputStream, Cliente[].class));
        try {
            clientes = objectMapper.readValue(new File(PATH), new TypeReference<ArrayList<Cliente>>(){});
        } catch (MismatchedInputException e) {}
        return clientes;
    }

    @Override
    public List<Cliente> get(Map<String,String> param) throws IOException {
        try {
            clientes = objectMapper.readValue(new File(PATH), new TypeReference<ArrayList<Cliente>>(){});
        } catch (MismatchedInputException e) {}

        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getKey().equals("id")) {
                clientes = clientes.stream().filter(c -> c.getId()==Long.valueOf(entry.getValue())).collect(Collectors.toList());
            }
            if (entry.getKey().equals("nome")) {
                clientes = clientes.stream().filter(c -> c.getNome().equals(String.valueOf(entry.getValue()))).collect(Collectors.toList());
            }
        }

        return clientes;
    }
}
