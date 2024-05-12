package com.groupid.projetobanco.models;

public class Contem {

    private int fk_Receita_id_receita;
    private int fk_Remedio_codigo_contem;

    public Contem(int fk_Receita_id_receita, int fk_Remedio_codigo_contem) {
        this.fk_Receita_id_receita = fk_Receita_id_receita;
        this.fk_Remedio_codigo_contem = fk_Remedio_codigo_contem;
    }

    // Getter e Setter ID da Receita
    public int getIdReceita() {
        return fk_Receita_id_receita;
    }

    public void setIdReceita(int fk_Receita_id_receita) {
        this.fk_Receita_id_receita = fk_Receita_id_receita;
    }

    // Getter e Setter Contem Codigo do Remedio
    public int getContemCodigoRemedio() {
        return fk_Remedio_codigo_contem;
    }

    public void setContemCodigoRemedio(int fk_Remedio_codigo_contem) {
        this.fk_Remedio_codigo_contem = fk_Remedio_codigo_contem;
    }
}