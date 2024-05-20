package com.groupid.projetobanco.models;

import java.util.Date;

public class Remedio {

    private String tipo;
    private int codigo;
    private String quantidade;
    private Date validade;
    private Date data_abertura;
    private String tempo_utilizacao;
    private String principio_ativo;
    private int cod_estoque;

    public Remedio(String tipo, int codigo, String quantidade, Date validade, 
    Date data_abertura, String tempo_utilizacao, String principio_ativo, 
    int cod_estoque) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.validade = validade;
        this.data_abertura = data_abertura;
        this.tempo_utilizacao = tempo_utilizacao;
        this.principio_ativo = principio_ativo;
        this.cod_estoque = cod_estoque;
    }

    // Getter e Setter Tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter e Setter Codigo
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // Getter e Setter Quantidade
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    // Getter e Setter Validade
    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    // Getter e Setter Data de Abertura
    public Date getDataAbertura() {
        return data_abertura;
    }

    public void setDataAbertura(Date data_abertura) {
        this.data_abertura = data_abertura;
    }

    // Getter e Setter Tempo de Utilização
    public String getTempoUtilizacao() {
        return tempo_utilizacao;
    }

    public void setTempoUtilizacao(String tempo_utilizacao) {
        this.tempo_utilizacao = tempo_utilizacao;
    }

    // Getter e Setter Princípio Ativo
    public String getPrincipioAtivo() {
        return principio_ativo;
    }

    public void setPrincipioAtivo(String principio_ativo) {
        this.principio_ativo = principio_ativo;
    }

    // Getter e Setter Codigo de Estoque
    public int getCodigoEstoque() {
        return cod_estoque;
    }

    public void setCodigoEstoque(int cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

}
