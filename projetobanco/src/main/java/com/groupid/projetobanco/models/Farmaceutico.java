package com.groupid.projetobanco.models;

public class Farmaceutico extends Funcionario{

    private String crf;
    private int matricula_farmaceutico;

    public Farmaceutico(String nome, String cargo, String crf) {
        super(nome, cargo);
        this.crf = crf;
    }

    // Getter e Setter CRF
    public String getCrf() {
        return crf;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    // Getter e Setter Matricula do Farmaceutico
    public int getMatriculaFarmaceutico() {
        return matricula_farmaceutico;
    }

    public void setMatriculaFarmaceutico(int matricula_farmaceutico) {
        this.matricula_farmaceutico = matricula_farmaceutico;
    }

}
