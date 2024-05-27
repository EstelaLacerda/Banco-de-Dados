package com.groupid.projetobanco.models;

import java.sql.Timestamp;

public class Receita {
    
    private int id_receita;
    private Timestamp data_hora_consulta;
    private String crm;
    private int matricula_medico;
    private int codigo_paciente;
    private String nome_remedio;
    private String dosagem;
    private int quantidade;
    private String unidade_medida;
    private String horario;
    private Timestamp data_prescricao;
    private boolean receita_controlada;
    private String status_receita;
    private String tempo_de_espera;
    

    public Receita(int id_receita, Timestamp data_hora_consulta, String crm, int matricula_medico, int codigo_paciente, String nome_remedio, 
     String dosagem,int quantidade, String unidade_medida, String horario, Timestamp data_prescricao, boolean receita_controlada, String status_receita,
     String tempo_de_espera){
      this.id_receita = id_receita;
      this.data_hora_consulta = data_hora_consulta;
      this.crm = crm;
      this.matricula_medico = matricula_medico;
      this.codigo_paciente = codigo_paciente;
      this.nome_remedio = nome_remedio;
      this.dosagem = dosagem;
      this.quantidade = quantidade;
      this.unidade_medida = unidade_medida;
      this.horario = horario;
      this.data_prescricao = data_prescricao;
      this.receita_controlada = receita_controlada;
      this.status_receita = status_receita;
      this.tempo_de_espera = tempo_de_espera;
       
    }

    public int getIdReceita() {
        return id_receita;
    }

    public void setIdReceita(int id_receita) {
        this.id_receita = id_receita;
    }

    public Timestamp getDataHoraConsulta() {
        return data_hora_consulta;
    }

    public void setDataHoraConsulta( Timestamp data_hora_consulta){
        this.data_hora_consulta = data_hora_consulta;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

     // Getter e Setter Matricula do Funcionario Medico
     public int getMatriculaFuncionarioMedico() {
        return matricula_medico;
    }

    public void setMatriculaFuncionarioMedico(int matricula_medico) {
        this.matricula_medico = matricula_medico;
    }

    public int getCodigoPaciente(){
        return codigo_paciente;
    }

    public void setCodigoPaciente(int codigo_paciente){
        this.codigo_paciente = codigo_paciente;
    }

    public String getNomeRemedio() {
        return nome_remedio;
    }

    public void setNomeRemedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidade_medida;
    }

    public void setUnidadeMedida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }
    
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Timestamp getDataPrescricao() {
        return data_prescricao;
    }

    public void setDataPrescricao(Timestamp data_prescricao) {
        this.data_prescricao = data_prescricao;
    }

    public boolean getReceitacontrolada(){
        return receita_controlada;
    }

    public void setReceitaControlada(boolean receita_controlada){
        this.receita_controlada = receita_controlada;
    }

    public String getStatusReceita() {
        return status_receita;
    }

    public void setStatusReceita(String status_receita) {
        this.status_receita = status_receita;
    }

    public String getTempoDeEspera() {
        return tempo_de_espera;
    }
    
    public void setTempoDeEspera( String tempo_de_espera){
        this.tempo_de_espera = tempo_de_espera;
    }
  

}