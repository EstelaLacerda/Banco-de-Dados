package com.groupid.projetobanco.models;

public class Contem {

    private int id_receita;
    private int codigo_remedio;

    public Contem(int id_receita, int codigo_remedio) {
        this.id_receita = id_receita;
        this.codigo_remedio = codigo_remedio;
    }

    // Getter e Setter ID da Receita
    public int getIdReceita() {
        return id_receita;
    }

    public void setIdReceita(int id_receita) {
        this.id_receita = id_receita;
    }

    // Getter e Setter Contem Codigo do Remedio
    public int getContemCodigoRemedio() {
        return codigo_remedio;
    }

    public void setContemCodigoRemedio(int codigo_remedio) {
        this.codigo_remedio = codigo_remedio;
    }
}