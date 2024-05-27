package com.groupid.projetobanco.models;

public class Recebe {

    private int matricula_funcionario;
    private int id_receita;

    public Recebe(int matricula_funcionario, int id_receita) {
        this.matricula_funcionario = matricula_funcionario;
        this.id_receita = id_receita;
    }

  
    public int getMatriculaFuncionario() {
        return matricula_funcionario;
    }

    public void setMatriculaFuncionario(int matricula_funcionario) {
        this.matricula_funcionario = matricula_funcionario;
    }

    // Getter e Setter ID da Receita Recebida
    public int getIdReceita() {
        return id_receita;
    }

    public void setIdReceita(int id_receita) {
        this.id_receita = id_receita;
    }
}