package com.groupid.projetobanco.models;

public class Remedio_controlado {
    private boolean foi_Aprovado;
    private String crf;
    private int fk_Remedio_codigo;

    public Remedio_controlado(boolean foi_Aprovado, String crf, int fk_Remedio_codigo) {
        this.foi_Aprovado = foi_Aprovado;
        this.crf = crf;
        this.fk_Remedio_codigo = fk_Remedio_codigo;
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
        return fk_Remedio_codigo;
    }

    public void setRemedioCodigo(int fk_Remedio_codigo) {
        this.fk_Remedio_codigo = fk_Remedio_codigo;
    }
}
