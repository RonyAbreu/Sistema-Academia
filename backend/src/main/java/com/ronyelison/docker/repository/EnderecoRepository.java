package com.ronyelison.docker.repository;

import com.ronyelison.docker.model.Endereco;
import com.ronyelison.docker.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
