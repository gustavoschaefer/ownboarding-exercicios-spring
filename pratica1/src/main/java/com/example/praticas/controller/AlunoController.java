package com.example.praticas.controller;

import com.example.praticas.dto.AlunoDto;
import com.example.praticas.entity.Aluno;
import com.example.praticas.entity.Diploma;

import com.example.praticas.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    private static final List<Aluno> alunos =
        Arrays.asList(
            Aluno.builder().matricula(1).nome("Aluno1").notas(Map.of("Aula1", 9,"Aula2", 8)).build(),
            Aluno.builder().matricula(2).nome("Aluno2").notas(Map.of("Aula1", 10,"Aula2", 9)).build(),
            Aluno.builder().matricula(3).nome("Aluno3").notas(Map.of("Aula1", 9,"Aula2", 10)).build()
        );

    @GetMapping("/alunos")
    private List<Aluno> getList() {
        return new ArrayList<>(alunos);
    }

    @PostMapping("/aluno")
    public ResponseEntity<AlunoDto> cadastra(@RequestBody AlunoDto alunoDto) {
        Aluno aluno = AlunoDto.toAluno(alunoDto);

        // TODO Salvar utilizando service aqui

        return ResponseEntity.ok(AlunoDto.toAlunoDto(aluno));
    }

    @PostMapping("/diploma")
    public ResponseEntity<Diploma> getDiploma(@RequestBody AlunoDto alunoDto) {
        Aluno aluno = AlunoDto.toAluno(alunoDto);
        float media = alunoService.media(aluno);
        String msg;
        if (media >= 9) {
            msg = "Parabéns, passou com mádia maior do que 9!";
        } else {
            msg = "Passou!";
        }
        Diploma diploma = Diploma.builder().nome(aluno.getNome()).msg(msg).media(media).build();
        return ResponseEntity.ok(diploma);
    }

}
