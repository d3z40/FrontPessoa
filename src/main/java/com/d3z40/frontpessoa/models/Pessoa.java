package com.d3z40.frontpessoa.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Pessoa implements Serializable {

    private int id;

    @NotBlank(message = "Campo \"Nome\" obrigatório")
    private String nome;

    @NotBlank(message = "Campo \"CPF\" obrigatório")
    private String cpf;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Campo \"Data de Nascimento\" obrigatório")
    private Date dataNascimento;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, Date dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
