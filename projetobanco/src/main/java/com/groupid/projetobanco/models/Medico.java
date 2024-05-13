package com.groupid.projetobanco.models;

public class Medico {

    private String crm;
    private int matricula_medico;

    public Medico(String crm, int matricula_medico) {
        this.crm = crm;
        this.matricula_medico = matricula_medico;
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
        return matricula_medico;
    }

    public void setMatriculaMedico(int matricula_medico) {
        this.matricula_medico = matricula_medico;
    }
}