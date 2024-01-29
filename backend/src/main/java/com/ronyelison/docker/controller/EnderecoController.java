package com.ronyelison.docker.controller;

import com.ronyelison.docker.dto.EnderecoDTO;
import com.ronyelison.docker.model.Endereco;
import com.ronyelison.docker.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/{idPessoa}")
    public ResponseEntity<Endereco> cadastrarEndereco(@RequestBody EnderecoDTO enderecoDTO, @PathVariable Long idPessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.cadastrarEndereco(enderecoDTO,idPessoa));
    }
}
