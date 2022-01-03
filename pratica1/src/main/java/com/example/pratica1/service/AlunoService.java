package com.example.pratica1.service;

import com.example.pratica1.entity.Aluno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    private static List<Aluno> alunoList = new ArrayList<>();

    public void salvar(Aluno aluno) {
        alunoList.add(aluno);
    }

    public List<Aluno> buscar() {
        return alunoList;
    }

    public float media(Aluno aluno) {
        Map<String,String> notas = aluno.getNotas();
        float media = 0;
        for (String nota: notas.values()) {
            media += Integer.parseInt(nota);
        }
        media = media / notas.size();
        return media;
    }

    public String msg(float media) {
        if (media >= 9) {
            return "Parabéns, passou com mádia maior do que 9!";
        } else {
            return "Passou!";
        }
    }

}
