package com.groupid.projetobanco.models;

public class Aprova {

    private int fk_Farmaceutico_fk_Funcionario_matricula_aprova;
    private int fk_Remedio_Controlado_fk_Remedio_codigo;

    public Aprova(int fk_Farmaceutico_fk_Funcionario_matricula_aprova, int fk_Remedio_Controlado_fk_Remedio_codigo) {
        this.fk_Farmaceutico_fk_Funcionario_matricula_aprova = fk_Farmaceutico_fk_Funcionario_matricula_aprova;
        this.fk_Remedio_Controlado_fk_Remedio_codigo = fk_Remedio_Controlado_fk_Remedio_codigo;
    }

    // Getter e Setter Matricula do Funcionario Farmaceutico Aprovada
    public int getMatriculaFuncionarioFarmaceuticoAprova() {
        return fk_Farmaceutico_fk_Funcionario_matricula_aprova;
    }

    public void setMatriculaFuncionarioFarmaceuticoAprova(int fk_Farmaceutico_fk_Funcionario_matricula_aprova) {
        this.fk_Farmaceutico_fk_Funcionario_matricula_aprova = fk_Farmaceutico_fk_Funcionario_matricula_aprova;
    }

    // Getter e Setter Codigo do Remedio Controlado
    public int getCodigoRemedioControlado() {
        return fk_Remedio_Controlado_fk_Remedio_codigo;
    }

    public void setCodigoRemedioControlado(int fk_Remedio_Controlado_fk_Remedio_codigo) {
        this.fk_Remedio_Controlado_fk_Remedio_codigo = fk_Remedio_Controlado_fk_Remedio_codigo;
    }
}