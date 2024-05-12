package com.groupid.projetobanco.models;

public class Recebe {

    private int fk_Farmaceutico_fk_Funcionario_matricula;
    private int fk_Receita_id_receita_recebe;

    public Recebe(int fk_Farmaceutico_fk_Funcionario_matricula, int fk_Receita_id_receita_recebe) {
        this.fk_Farmaceutico_fk_Funcionario_matricula = fk_Farmaceutico_fk_Funcionario_matricula;
        this.fk_Receita_id_receita_recebe = fk_Receita_id_receita_recebe;
    }

    // Getter e Setter Matricula do Funcionario Farmaceutico
    public int getMatriculaFuncionarioFarmaceutico() {
        return fk_Farmaceutico_fk_Funcionario_matricula;
    }

    public void setMatriculaFuncionarioFarmaceutico(int fk_Farmaceutico_fk_Funcionario_matricula) {
        this.fk_Farmaceutico_fk_Funcionario_matricula = fk_Farmaceutico_fk_Funcionario_matricula;
    }

    // Getter e Setter ID da Receita Recebida
    public int getIdReceitaRecebe() {
        return fk_Receita_id_receita_recebe;
    }

    public void setIdReceitaRecebe(int fk_Receita_id_receita_recebe) {
        this.fk_Receita_id_receita_recebe = fk_Receita_id_receita_recebe;
    }
}