package com.example.gestaoclientes.controller.repository;

import java.io.IOException;
import java.util.List;

public interface Repository <T,U>{

    void save(T t) throws IOException;
    List<T> list() throws IOException;
    List<T> get(U id) throws IOException;
}
