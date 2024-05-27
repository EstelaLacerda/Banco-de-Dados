package com.groupid.projetobanco.models;

public class Remedio {


    private int codigo_remedio;
    private String nome;
    private String principio_ativo;
    private String tipo;
    private String quantidade;
    private String unidade_medida;
    private String dosagem;
    private int cod_estoque;
    private int controlado;
  
    public Remedio(int codigo_remedio, String nome, String principio_ativo, String tipo, String quantidade,
    String unidade_medida, String dosagem, int cod_estoque, int controlado) {
        this.codigo_remedio = codigo_remedio;
        this.nome = nome;
        this.principio_ativo = principio_ativo;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.unidade_medida = unidade_medida;
        this.dosagem = dosagem;
        this.cod_estoque = cod_estoque;
        this.controlado = controlado;
       
    }

     // Getter e Setter
     public int getCodigo() {
        return codigo_remedio;
    }

    public void setCodigo(int codigo_remedio) {
        this.codigo_remedio = codigo_remedio;
    }

       
    public String getNomeRemedio() {
        return nome;
    }

    public void setNomeRemedio(String nome) {
        this.nome = nome;
    }

    public String getPrincipioAtivo() {
        return principio_ativo;
    }

    public void setPrincipioAtivo(String principio_ativo) {
        this.principio_ativo = principio_ativo;
    }

    // Getter e Setter Tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
    // Getter e Setter Quantidade
    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedida() {
        return unidade_medida;
    }

    public void setUnidadeMedida(String unidade_medida){
        this.unidade_medida = unidade_medida;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem){
        this.dosagem = dosagem;
    }

    public int getCodEstoque() {
        return cod_estoque;
    }

    public void setCodEstoque(int cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

    public int getControlado(){
        return controlado;
    }

    public void setControlado(int controlado){
        this.controlado = controlado;
    }


}
