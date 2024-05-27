package com.groupid.projetobanco.models;

public class Telefone{

    private int id;
    private int cod_paciente;
    private String numero;

    public Telefone(int id, int cod_paciente, String numero){
        this.id =id;
        this.cod_paciente = cod_paciente;
        this.numero = numero;
    }

    public int getId() {
        return id;   
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodPaciente(){
        return cod_paciente;
    }

    public void setCodPaciente(int cod_paciente){
        this.cod_paciente =cod_paciente;
    }

    public String getNumero(){
        return numero;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }


}
    

