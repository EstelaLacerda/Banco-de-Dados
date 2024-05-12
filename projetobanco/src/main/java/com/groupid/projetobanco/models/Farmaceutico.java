package com.groupid.projetobanco.models;

public class Farmaceutico {

    private String crf;
    private int fk_Funcionario_matricula_farmaceutico;

    public Farmaceutico(String crf, int fk_Funcionario_matricula_farmaceutico) {
        this.crf = crf;
        this.fk_Funcionario_matricula_farmaceutico = fk_Funcionario_matricula_farmaceutico;
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
        return fk_Funcionario_matricula_farmaceutico;
    }

    public void setMatriculaFarmaceutico(int fk_Funcionario_matricula_farmaceutico) {
        this.fk_Funcionario_matricula_farmaceutico = fk_Funcionario_matricula_farmaceutico;
    }
}
