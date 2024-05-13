package com.groupid.projetobanco.models;

import java.sql.Time;
import java.util.Date;

public class Receita {

    private Date data_prescricao;
    private int id_receita;
    private String crm;
    private String quantidade;
    private String horario;
    private String dosagem;
    private String status_receita;
    private Time hora_consulta;
    private int matricula_medico;
    private String cpf_paciente;

    // Getter e Setter Data de Prescrição
    public Date getDataPrescricao() {
        return data_prescricao;
    }

    public void setDataPrescricao(Date data_prescricao) {
        this.data_prescricao = data_prescricao;
    }

    // Getter e Setter ID da Receita
    public int getIdReceita() {
        return id_receita;
    }

    public void setIdReceita(int id_receita) {
        this.id_receita = id_receita;
    }

    // Getter e Setter CRM
    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    // Getter e Setter Quantidade
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    // Getter e Setter Horário
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    // Getter e Setter Dosagem
    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    // Getter e Setter Status da Receita
    public String getStatusReceita() {
        return status_receita;
    }

    public void setStatusReceita(String status_receita) {
        this.status_receita = status_receita;
    }

    // Getter e Setter Hora da Consulta
    public Time getHoraConsulta() {
        return hora_consulta;
    }

    public void setHoraConsulta(Time hora_consulta) {
        this.hora_consulta = hora_consulta;
    }

    // Getter e Setter Matricula do Funcionario Medico
    public int getMatriculaFuncionarioMedico() {
        return matricula_medico;
    }

    public void setMatriculaFuncionarioMedico(int matricula_medico) {
        this.matricula_medico = matricula_medico;
    }

    // Getter e Setter FK_Paciente_CPF
    public String getCpfPaciente() {
        return cpf_paciente;
    }

    public void setCpfPaciente(String cpf_paciente) {
        this.cpf_paciente = cpf_paciente;
    }
}