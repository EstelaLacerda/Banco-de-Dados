package com.groupid.projetobanco.models;

public class Aprova {

    private int matricula_farmaceutico;
    private int id_receita_controlada;

    public Aprova(int matricula_farmaceutico, int id_receita_controlada) {
        this.matricula_farmaceutico = matricula_farmaceutico;
        this.id_receita_controlada = id_receita_controlada;
    }

    // Getter e Setter Matricula do Funcionario Farmaceutico Aprovada
    public int getMatriculaFuncionarioFarmaceuticoAprova() {
        return matricula_farmaceutico;
    }

    public void setMatriculaFuncionarioFarmaceuticoAprova(int matricula_farmaceutico) {
        this.matricula_farmaceutico = matricula_farmaceutico;
    }

   
    public int getIdReceitaControlada() {
        return id_receita_controlada;
    }

    public void setidReceitaControlada(int id_receita_controlada) {
        this.id_receita_controlada = id_receita_controlada;
    }
}