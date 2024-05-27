package com.groupid.projetobanco.models;

import java.sql.Timestamp;
import java.time.LocalDate;

public class Estoque {

    private int cod_estoque;
    private int unidades;
    private int quantidade_de_remedios;
    private Timestamp data_ultima_atualizacao; 
    private String nome_remedio;
    private String unidade_medida;
    private String status_estoque; 
    private LocalDate data_de_validade;

    public Estoque(int cod_estoque, int unidades, int quantidade_de_remedios, Timestamp data_ultima_atualizacao, String nome_remedio,
    String unidade_medida, String status_estoque, LocalDate data_de_validade) {
        this.cod_estoque = cod_estoque;
        this.unidades = unidades;
        this.quantidade_de_remedios = quantidade_de_remedios;
        this.data_ultima_atualizacao = data_ultima_atualizacao;
        this.nome_remedio = nome_remedio;
        this.unidade_medida = unidade_medida;
        this.status_estoque = status_estoque;
        this.data_de_validade = data_de_validade;
    }

    // Getter e Setter Matricula do Código do Estoque
    public int getCodigoEstoque() {
        return cod_estoque;
    }

    public void setCodigoEstoque(int cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades){
        this.unidades = unidades;
    }

    // Getter e Setter Quantidade de Remédios
    public int getQuantidadeDeRemedios() {
        return quantidade_de_remedios;
    }

    public void setQuantidadeDeRemedios(int quantidade_de_remedios) {
        this.quantidade_de_remedios = quantidade_de_remedios;
    }

    // Getter e Setter Ultima Atualização
    public Timestamp getDataUltimaAtualizacao() {
        return data_ultima_atualizacao;
    }

    public void setDataUltimaAtualizacao(Timestamp data_ultima_atualizacao) {
        this.data_ultima_atualizacao = data_ultima_atualizacao;
    }

    // Getter e Setter Nome do Remédio
    public String getNome_Remedio() {
        return nome_remedio;
    }

    public void setNome_Remedio(String nome_remedio) {
        this.nome_remedio = nome_remedio;
    }

    // Getter e Setter Unidade de Medida
    public String getUnidade_Medida() {
        return unidade_medida;
    }

    public void setUnidade_Medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    // Getter e Setter Status do Estoque
    public String getStatusEstoque() {
        return status_estoque;
    }

    public void setStatusEstoque(String status_estoque) {
        this.status_estoque = status_estoque;
    }

    // Getter e Setter Data de Validade
    public LocalDate getDataValidade() {
        return data_de_validade;
    }

    public void setDataValidade(LocalDate data_de_validade) {
        this.data_de_validade = data_de_validade;
    }
}