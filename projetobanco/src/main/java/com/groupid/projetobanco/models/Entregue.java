package com.groupid.projetobanco.models;

public class Entregue {
    
    private int matricula_funcionario;
    private int id_receita;
    private int codigo_do_setor;

    public Entregue(int matricula_funcionario, int id_receita, int codigo_do_setor){
        this.matricula_funcionario  = matricula_funcionario;
        this.id_receita = id_receita;
        this.codigo_do_setor = codigo_do_setor;
    }

    public int getMatriculaFuncionario(){
        return matricula_funcionario;
    }
    public void setMatriculaFuncionario( int matricula_funcionario){
        this.matricula_funcionario = matricula_funcionario;
    }
    public int getIdReceita(){
        return id_receita;
    }
    public void setIdReceita(int matricula_funcionario){
        this.matricula_funcionario = matricula_funcionario;
    }
    public int getCodigoDoSetor(){
        return codigo_do_setor;
    }

    public void setCodigoDoSetor(int codigo_do_setor){
        this.codigo_do_setor = codigo_do_setor;
    }

}
