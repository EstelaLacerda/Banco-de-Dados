package com.groupid.projetobanco.models;

public class Medico extends Funcionario {

    private String crm;
    private int matricula_medico;

    public Medico(int matricula, String nome, String cargo, String crm, int matricula_medico) {
        super(matricula, nome, cargo);
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
    public int getMatricula_Medico() {
        return matricula_medico;
    }

    public void setMatricula_Medico(int matricula_medico) {
        this.matricula_medico = matricula_medico;
    }

}