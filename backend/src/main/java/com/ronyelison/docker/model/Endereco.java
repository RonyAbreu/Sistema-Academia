package com.ronyelison.docker.model;

import com.ronyelison.docker.dto.EnderecoDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String bairro;
    private Integer numeroDaCasa;
    @OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
    private List<Pessoa> pessoas = new ArrayList<>();

    public Endereco(){
    }

    public Endereco(EnderecoDTO enderecoDTO) {
        this.rua = enderecoDTO.rua();
        this.bairro = enderecoDTO.bairro();
        this.numeroDaCasa = enderecoDTO.numeroDaCasa();
    }

    public void adicionarPessoa(Pessoa pessoa){
        this.pessoas.add(pessoa);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(Integer numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }
}
