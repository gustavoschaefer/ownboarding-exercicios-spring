package com.example.praticas.service;

import com.example.praticas.entity.Aluno;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AlunoService {
    public void salvar(Aluno aluno) {

    }

    public float media(Aluno aluno) {
        Map<String,Integer> notas = aluno.getNotas();
        float media = 0;
        for (Integer nota: notas.values()) {
            media += nota;
        }
        media = media / notas.size();
        return media;
    }

}
