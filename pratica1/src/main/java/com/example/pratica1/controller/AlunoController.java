package com.example.pratica1.controller;

import com.example.pratica1.dto.AlunoDTO;
import com.example.pratica1.entity.Aluno;
import com.example.pratica1.entity.Diploma;
import com.example.pratica1.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;



    @GetMapping("/alunos")
    private ResponseEntity<List<AlunoDTO>> getList() {
        ArrayList<AlunoDTO> alunoDTOS = new ArrayList<>();
        for (Aluno aluno : alunoService.buscar()) {
            alunoDTOS.add(AlunoDTO.toAlunoDto(aluno));
        }
        return ResponseEntity.ok(alunoDTOS);
    }

    @PostMapping("/aluno")
    public ResponseEntity<AlunoDTO> cadastra(@Valid @RequestBody AlunoDTO alunoDto, UriComponentsBuilder uriBuilder) {
        Aluno aluno = AlunoDTO.toAluno(alunoDto);
        alunoService.salvar(aluno);
        URI uri = uriBuilder
                .path("/alunos")
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(AlunoDTO.toAlunoDto(aluno));
    }

    @PostMapping("/diploma")
    public ResponseEntity<Diploma> getDiploma(@RequestBody AlunoDTO alunoDto) {
        Aluno aluno = AlunoDTO.toAluno(alunoDto);
        float media = alunoService.media(aluno);
        Diploma diploma = Diploma.builder().nome(aluno.getNome()).msg(alunoService.msg(media)).media(media).build();
        return ResponseEntity.ok(diploma);
    }

}
