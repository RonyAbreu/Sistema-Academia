package com.ronyelison.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronyelison.docker.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
