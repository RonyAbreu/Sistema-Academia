package com.ronyelison.docker.repository;

import com.ronyelison.docker.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    Pessoa findByNomeAndIdadeAndPeso(String nome, Integer idade, Double peso);
}
