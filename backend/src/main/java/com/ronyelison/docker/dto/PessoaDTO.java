package com.ronyelison.docker.dto;
public record PessoaDTO(
         String nome,
         Integer idade,
         Double peso,
         Double altura,
         Boolean temDiabetes,
         Boolean temPressaoAlta
) {

}
