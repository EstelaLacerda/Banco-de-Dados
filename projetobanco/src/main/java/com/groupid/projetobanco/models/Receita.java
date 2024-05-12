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
    private Time fk_Consulta_hora;
    private int fk_fk_Medico_fk_Funcionario_matricula;
    private String fk_fk_Paciente_cpf;

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
        return fk_Consulta_hora;
    }

    public void setHoraConsulta(Time fk_Consulta_hora) {
        this.fk_Consulta_hora = fk_Consulta_hora;
    }

    // Getter e Setter Matricula do Funcionario Medico
    public int getMatriculaFuncionarioMedico() {
        return fk_fk_Medico_fk_Funcionario_matricula;
    }

    public void setMatriculaFuncionarioMedico(int fk_fk_Medico_fk_Funcionario_matricula) {
        this.fk_fk_Medico_fk_Funcionario_matricula = fk_fk_Medico_fk_Funcionario_matricula;
    }

    // Getter e Setter FK_Paciente_CPF
    public String getCpfPaciente() {
        return fk_fk_Paciente_cpf;
    }

    public void setCpfPaciente(String fk_fk_Paciente_cpf) {
        this.fk_fk_Paciente_cpf = fk_fk_Paciente_cpf;
    }
}