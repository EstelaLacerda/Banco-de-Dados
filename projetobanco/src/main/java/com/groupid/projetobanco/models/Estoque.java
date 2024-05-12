package com.groupid.projetobanco.models;

import java.util.Date;

public class Estoque {

    private int cod_estoque;
    private int quantidade_de_remedios;
    private Date data_ultima_atualizacao; 

    public Estoque(int cod_estoque, int quantidade_de_remedios, Date data_ultima_atualizacao) {
        this.cod_estoque = cod_estoque;
        this.quantidade_de_remedios = quantidade_de_remedios;
        this.data_ultima_atualizacao = data_ultima_atualizacao;
    }

    // Getter e Setter Matricula do Código do Estoque
    public int getCodigoEstoque() {
        return cod_estoque;
    }

    public void setCodigoEstoque(int cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

    // Getter e Setter Matricula da Quantidade de Remédios
    public int getQuantidadeDeRemedios() {
        return quantidade_de_remedios;
    }

    public void setQuantidadeDeRemedios(int quantidade_de_remedios) {
        this.quantidade_de_remedios = quantidade_de_remedios;
    }

    // Getter e Setter Matricula da Quantidade de Remédios
    public Date getDataUltimaAtualizacao() {
        return data_ultima_atualizacao;
    }

    public void setQuantidadeDeRemedios(Date data_ultima_atualizacao) {
        this.data_ultima_atualizacao = data_ultima_atualizacao;
    }
}
