package com.groupid.projetobanco.models;

public class Remedio_controlado {
    private boolean foi_Aprovado;
    private String crf;
    private int codigo_remedio;

    public Remedio_controlado(boolean foi_Aprovado, String crf, int codigo_remedio) {
        this.foi_Aprovado = foi_Aprovado;
        this.crf = crf;
        this.codigo_remedio = codigo_remedio;
    }

    // Getter e Setter Foi Aprovado
    public boolean getFoiAprovado() {
        return foi_Aprovado;
    }

    public void setFoiAprovado(boolean foi_Aprovado) {
        this.foi_Aprovado = foi_Aprovado;
    }

    // Getter e Setter CRF
    public String getCrf() {
        return crf;
    }

    public void setCrf(String crf) {
        this.crf = crf;
    }

    // Getter e Setter Codigo do Remedio
    public int getRemedioCodigo() {
        return codigo_remedio;
    }

    public void setRemedioCodigo(int codigo_remedio) {
        this.codigo_remedio = codigo_remedio;
    }
}
