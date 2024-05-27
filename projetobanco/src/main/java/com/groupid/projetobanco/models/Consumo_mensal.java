package com.groupid.projetobanco.models;

public class Consumo_mensal {
    
    private int codigo_consumo_mensal;
    private int codigo_remedio;
    private String mes;
    private int consumo_mensal;
    private String unidade_medida;
    private int consumo_mensal_medio;

    public Consumo_mensal(int codigo_consumo_mensal, int codigo_remedio, String mes,
     int consumo_mensal, String unidade_medida, int consumo_mensal_medio){
        this.codigo_consumo_mensal = codigo_consumo_mensal;
        this.codigo_remedio = codigo_remedio;
        this.mes = mes;
        this.consumo_mensal = consumo_mensal;
        this.unidade_medida = unidade_medida;
        this.consumo_mensal_medio = consumo_mensal_medio;
     }
        public int getCodigoConsumoMensal() {
            return codigo_consumo_mensal;
        }
        public void setCondigoConsumoMensal(int codigo_consumo_mensal){
            this.codigo_consumo_mensal =codigo_consumo_mensal;
        }

        public int getCodigoRemedio(){
            return codigo_remedio;
        }

        public void setCodigoRemedio(int codigo_remedio) {
            this.codigo_remedio = codigo_remedio;
        }

        public String getMes(){
            return mes;
        }

        public void setMes(String mes){
            this.mes = mes;
        }

        public int getConsumoMensal(){
            return consumo_mensal;
        }

        public void setConsumoMensal(int consumo_mensal){
            this.consumo_mensal = consumo_mensal;
        }

        public String getUnidadeMedida(){
            return unidade_medida;
        }

        public void setUnidadeMedida() {
            this.unidade_medida = unidade_medida;
        }

        public int getConsumoMensalMedio() {
            return consumo_mensal_medio;
        }
        
}

