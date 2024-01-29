package com.ronyelison.docker.controller;

import com.ronyelison.docker.dto.PessoaDTO;
import com.ronyelison.docker.model.Pessoa;
import com.ronyelison.docker.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody PessoaDTO pessoaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarPessoa(pessoaDTO));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodos(){
        return ResponseEntity.ok(service.listarTodos());
    }
}
