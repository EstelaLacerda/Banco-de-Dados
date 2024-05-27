package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Recebe;

@Repository
public class RecebeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertRecebe(Recebe recebe) {
        jdbcTemplate.update("INSERT INTO RECEBE(MATRICULA_FUNCIONARIO, ID_RECEITA) VALUES(?, ?)",
        recebe.getMatriculaFuncionario(), recebe.getIdReceita());
    }

    public boolean deleteRecebe(int matricula_funcionario, int id_receita){

        int rowsAffected = jdbcTemplate.update("DELETE FROM RECEBE WHERE MATRICULA_FUNCIONARIO = ? AND ID_RECEITA = ?", matricula_funcionario, id_receita);
        return rowsAffected > 0;
    }

    public List<Recebe> getAllRecebe(){
        return jdbcTemplate.query("SELECT * FROM RECEBE", (resultSet, rowNum) -> {
            Recebe recebe = new Recebe(rowNum, rowNum);
            recebe.setMatriculaFuncionario(resultSet.getInt("MATRICULA_FUNCIONARIO"));
            recebe.setIdReceita(resultSet.getInt("ID_RECEITA"));
            return recebe;
        });
    }

}
