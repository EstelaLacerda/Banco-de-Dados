package com.groupid.projetobanco.models;

public class Receita_controle_especial {
    private boolean foi_aprovado;
    private String crf;
    private int id_receita;

    public Receita_controle_especial(boolean foi_aprovado, String crf, int id_receita) {
        this.foi_aprovado = foi_aprovado;
        this.crf = crf;
        this.id_receita = id_receita;
    }

    // Getter e Setter Foi Aprovado
    public boolean getFoiAprovado() {
        return foi_aprovado;
    }

    public void setFoiAprovado(boolean foi_aprovado) {
        this.foi_aprovado = foi_aprovado;
    }

    // Getter e Setter CRF
    public String getCrf() {
        return crf;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    // Getter e Setter Codigo do Remedio
    public int getIdReceita() {
        return id_receita;
    }

    public void setIdReceita(int id_receita) {
        this.id_receita = id_receita;
    }
}
