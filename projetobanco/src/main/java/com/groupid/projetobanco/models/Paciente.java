package com.groupid.projetobanco.models;

import java.util.Date;

public class Paciente {

    private int codigo_paciente;
    private String nome;
    private String cpf;
    private String sexo;
    private int idade;
    private float peso;
    private String nome_mae;
    private Date data_nascimento;
    private int codigo_setor;
    private String status_paciente;

    public Paciente(int codigo_paciente, String nome, String cpf, String sexo, int idade, float peso, String nome_mae, Date data_nascimento, int codigo_setor, String status_paciente){
        this.codigo_paciente = codigo_paciente;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.idade = idade;
        this.peso = peso;
        this.nome_mae = nome_mae;
        this.data_nascimento = data_nascimento;
        this.codigo_setor = codigo_setor;
        this.status_paciente = status_paciente;
    }



    public int getCodigoPaciente(){
        return codigo_paciente;
    }

    public void setCodigoPaciente(int codigo_paciente){
        this.codigo_paciente = codigo_paciente;
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

    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

   
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

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

    public String getStatusPaciente(){
        return status_paciente;
    }

    public void setStatusPaciente(String status_paciente){
        this.status_paciente = status_paciente;
    }
}
