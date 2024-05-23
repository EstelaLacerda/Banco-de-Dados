package com.groupid.projetobanco.models;

public class Setor_hospitalar {

    private int codigo_Setor;
    private String nome_do_setor;

    public Setor_hospitalar(int codigo_Setor, String nome_do_setor) {
        this.codigo_Setor = codigo_Setor;
        this.nome_do_setor = nome_do_setor;
    }

    // Getter e Setter Código do Setor
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

}
