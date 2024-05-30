package com.groupid.projetobanco.models;

public class Setor_hospitalar {

    private int codigo_Setor;
    private String nome_do_setor;
    private int quantidade_receitas;

    public Setor_hospitalar(String nome_do_setor, int quantidade_receitas) {
        this.nome_do_setor = nome_do_setor;
        this.quantidade_receitas = quantidade_receitas;
    }

    public int getCodigoSetor() {
        return codigo_Setor;
    }

    public void setCodigoSetor(int codigo_Setor) {
        this.codigo_Setor = codigo_Setor;
    }


    public String getNomeDoSetor() {
        return nome_do_setor;
    }

    public void setNomeDoSetor(String nome_do_setor) {
        this.nome_do_setor = nome_do_setor;
    }

    public int getQuantidadeReceitas() {
        return quantidade_receitas;
    }

    public void setQuantidadeReceitas(int quantidade_receitas) {
        this.quantidade_receitas = quantidade_receitas;
    }

}
