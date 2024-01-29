package com.ronyelison.docker.dto;

import com.ronyelison.docker.model.Pessoa;

public record PessoaDTO(
         String nome,
         Integer idade,
         Double peso,
         Double altura,
         Boolean temDiabetes,
         Boolean temPressaoAlta
) {

}
