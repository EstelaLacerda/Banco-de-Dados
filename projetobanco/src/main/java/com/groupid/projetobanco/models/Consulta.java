package com.groupid.projetobanco.models;

import java.sql.Time;

public class Consulta {

    private Time hora;
    private String cpf_Paciente;
    private int matricula_medico;

    public Consulta(Time hora, String cpf_Paciente, int matricula_medico) {
        this.hora = hora;
        this.cpf_Paciente = cpf_Paciente;
        this.matricula_medico = matricula_medico;
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
        return cpf_Paciente;
    }

    public void setCpfPaciente(String cpf_Paciente) {
        this.cpf_Paciente = cpf_Paciente;
    }

    // Getter e Setter Matricula do Funcionario Medico
    public int getMatriculaFuncionarioMedico() {
        return matricula_medico;
    }

    public void setMatriculaFuncionarioMedico(int matricula_medico) {
        this.matricula_medico = matricula_medico;
    }
}