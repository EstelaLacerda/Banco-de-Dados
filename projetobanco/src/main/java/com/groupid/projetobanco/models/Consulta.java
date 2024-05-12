package com.groupid.projetobanco.models;

import java.sql.Time;

public class Consulta {

    private Time hora;
    private String fk_Paciente_cpf;
    private int fk_Medico_fk_Funcionario_matricula;

    public Consulta(Time hora, String fk_Paciente_cpf, int fk_Medico_fk_Funcionario_matricula) {
        this.hora = hora;
        this.fk_Paciente_cpf = fk_Paciente_cpf;
        this.fk_Medico_fk_Funcionario_matricula = fk_Medico_fk_Funcionario_matricula;
    }

    // Getter e Setter Hora
    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    // Getter e Setter CPF do Paciente
    public String getCpfPaciente() {
        return fk_Paciente_cpf;
    }

    public void setCpfPaciente(String fk_Paciente_cpf) {
        this.fk_Paciente_cpf = fk_Paciente_cpf;
    }

    // Getter e Setter Matricula do Funcionario Medico
    public int getMatriculaFuncionarioMedico() {
        return fk_Medico_fk_Funcionario_matricula;
    }

    public void setMatriculaFuncionarioMedico(int fk_Medico_fk_Funcionario_matricula) {
        this.fk_Medico_fk_Funcionario_matricula = fk_Medico_fk_Funcionario_matricula;
    }
}