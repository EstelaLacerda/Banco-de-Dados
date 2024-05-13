package com.groupid.projetobanco.models;

import java.util.Date;

public class Paciente {

    private String nome;
    private String cpf;
    private String sexo;
    private int idade;
    private float peso;
    private String nome_mae;
    private Date data_nascimento;
    private int codigo_setor;

    // Getter e Setter Nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Getter e Setter Sexo
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    // Getter e Setter Idade
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Getter e Setter Peso
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    // Getter e Setter Nome da Mãe
    public String getNomeMae() {
        return nome_mae;
    }

    public void setNomeMae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    // Getter e Setter Data de Nascimento
    public Date getDataNascimento() {
        return data_nascimento;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    // Getter e Setter Codigo do Setor Hospitalar
    public int getCodigoSetorHospitalar() {
        return codigo_setor;
    }

    public void setCodigoSetorHospitalar(int codigo_setor) {
        this.codigo_setor = codigo_setor;
    }
}
