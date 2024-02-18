package com.ronyelison.docker.service;

import com.ronyelison.docker.dto.PessoaDTO;
import com.ronyelison.docker.model.Pessoa;
import com.ronyelison.docker.repository.PessoaRepository;
import com.ronyelison.docker.service.exceptions.PessoaJaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public Pessoa cadastrarPessoa(PessoaDTO pessoaDTO) throws PessoaJaExisteException {
        Pessoa pessoa = repository.findByNomeAndIdadeAndPeso(pessoaDTO.nome(), pessoaDTO.idade(), pessoaDTO.peso());
        if (pessoa != null){
            throw new PessoaJaExisteException("Pessoa já foi cadastrada!");
        }

        Pessoa pessoaParaSalvar = new Pessoa(pessoaDTO);
        return repository.save(pessoaParaSalvar);
    }

    public List<Pessoa> listarTodos(){
        return repository.findAll();
    }
}
