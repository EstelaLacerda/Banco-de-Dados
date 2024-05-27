package com.groupid.projetobanco.models;

import java.security.Timestamp;
import java.sql.Time;

public class Consulta {

    private Timestamp data_hora;
    private int codigo_paciente;
    private int matricula_medico;

    public Consulta(Timestamp data_hora, int codigo_paciente, int matricula_medico) {
        this.data_hora = data_hora;
        this.codigo_paciente = codigo_paciente;
        this.matricula_medico = matricula_medico;
    }

    
    public Timestamp getDataHora() {
        return data_hora;
    }

    public void setDataHora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public int getCodigoPaciente() {
        return codigo_paciente;
    }

    public void setCodigoPaciente(int codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }
   

    public int getMatriculaFuncionarioMedico() {
        return matricula_medico;
    }

    public void setMatriculaFuncionarioMedico(int matricula_medico) {
        this.matricula_medico = matricula_medico;
    }
}