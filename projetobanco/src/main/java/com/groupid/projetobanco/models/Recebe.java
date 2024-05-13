package com.groupid.projetobanco.models;

public class Recebe {

    private int matricula_farmaceutico;
    private int id_receita;

    public Recebe(int matricula_farmaceutico, int id_receita) {
        this.matricula_farmaceutico = matricula_farmaceutico;
        this.id_receita = id_receita;
    }

    // Getter e Setter Matricula do Funcionario Farmaceutico
    public int getMatriculaFuncionarioFarmaceutico() {
        return matricula_farmaceutico;
    }

    public void setMatriculaFuncionarioFarmaceutico(int matricula_farmaceutico) {
        this.matricula_farmaceutico = matricula_farmaceutico;
    }

    // Getter e Setter ID da Receita Recebida
    public int getIdReceitaRecebe() {
        return id_receita;
    }

    public void setIdReceitaRecebe(int id_receita) {
        this.id_receita = id_receita;
    }
}