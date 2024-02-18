package com.ronyelison.docker.model;

import com.ronyelison.docker.dto.PessoaDTO;
import jakarta.persistence.*;

@Entity(name = "tb_pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer idade;
    private Double peso;
    private Double altura;
    private Boolean temDiabetes;
    private Boolean temPressaoAlta;
    @OneToOne
    private Endereco endereco;

    public Pessoa(){

    }

    public Pessoa(PessoaDTO pessoaDTO) {
        this.nome = pessoaDTO.nome();
        this.idade = pessoaDTO.idade();
        this.peso = pessoaDTO.peso();
        this.altura = pessoaDTO.altura();
        this.temDiabetes = pessoaDTO.temDiabetes();
        this.temPressaoAlta = pessoaDTO.temPressaoAlta();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Boolean getTemDiabetes() {
        return temDiabetes;
    }

    public void setTemDiabetes(Boolean temDiabetes) {
        this.temDiabetes = temDiabetes;
    }

    public Boolean getTemPressaoAlta() {
        return temPressaoAlta;
    }

    public void setTemPressaoAlta(Boolean temPressaoAlta) {
        this.temPressaoAlta = temPressaoAlta;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
