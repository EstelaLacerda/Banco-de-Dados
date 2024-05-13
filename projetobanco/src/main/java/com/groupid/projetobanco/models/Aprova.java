package com.groupid.projetobanco.models;

public class Aprova {

    private int matricula_farmaceutico;
    private int codigo_remedio_controlado;

    public Aprova(int matricula_farmaceutico, int codigo_remedio_controlado) {
        this.matricula_farmaceutico = matricula_farmaceutico;
        this.codigo_remedio_controlado = codigo_remedio_controlado;
    }

    // Getter e Setter Matricula do Funcionario Farmaceutico Aprovada
    public int getMatriculaFuncionarioFarmaceuticoAprova() {
        return matricula_farmaceutico;
    }

    public void setMatriculaFuncionarioFarmaceuticoAprova(int matricula_farmaceutico) {
        this.matricula_farmaceutico = matricula_farmaceutico;
    }

    // Getter e Setter Codigo do Remedio Controlado
    public int getCodigoRemedioControlado() {
        return codigo_remedio_controlado;
    }

    public void setCodigoRemedioControlado(int codigo_remedio_controlado) {
        this.codigo_remedio_controlado = codigo_remedio_controlado;
    }
}