package com.groupid.projetobanco.models;

public class Medico {

    private String crm;
    private int fk_Funcionario_matricula_medico;

    public Medico(String crm, int fk_Funcionario_matricula_medico) {
        this.crm = crm;
        this.fk_Funcionario_matricula_medico = fk_Funcionario_matricula_medico;
    }

    // Getter e Setter CRM
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    // Getter e Setter Matricula do Medico
    public int getMatriculaMedico() {
        return fk_Funcionario_matricula_medico;
    }

    public void setMatriculaMedico(int fk_Funcionario_matricula_medico) {
        this.fk_Funcionario_matricula_medico = fk_Funcionario_matricula_medico;
    }
}