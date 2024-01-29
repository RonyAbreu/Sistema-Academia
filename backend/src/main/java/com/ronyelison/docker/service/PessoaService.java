package com.ronyelison.docker.service;

import com.ronyelison.docker.dto.PessoaDTO;
import com.ronyelison.docker.model.Pessoa;
import com.ronyelison.docker.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa cadastrarPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa(pessoaDTO);
        return repository.save(pessoa);
    }

    public List<Pessoa> listarTodos(){
        return repository.findAll();
    }
}
