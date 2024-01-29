package com.ronyelison.docker.service;

import com.ronyelison.docker.dto.EnderecoDTO;
import com.ronyelison.docker.model.Endereco;
import com.ronyelison.docker.model.Pessoa;
import com.ronyelison.docker.repository.EnderecoRepository;
import com.ronyelison.docker.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO, Long idPessoa){
        Endereco endereco = new Endereco(enderecoDTO);
        Pessoa pessoa = pessoaRepository.findById(idPessoa).orElseThrow(() -> new RuntimeException("Pessoa não existe!"));

        pessoa.setEndereco(endereco);
        endereco.adicionarPessoa(pessoa);

        return enderecoRepository.save(endereco);
    }
}
