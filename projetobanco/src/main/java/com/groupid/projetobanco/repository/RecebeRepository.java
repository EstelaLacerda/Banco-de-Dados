package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.groupid.projetobanco.models.Recebe;

public class RecebeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertRecebe(Recebe recebe) {
        jdbcTemplate.update("INSERT INTO RECEBE(MATRICULA_FARMACEUTICO, ID_RECEITA) VALUES(?, ?)",
        recebe.getMatriculaFuncionarioFarmaceutico(), recebe.getIdReceitaRecebe());
    }

    public boolean deleteRecebe(int id_receita){

        int rowsAffected = jdbcTemplate.update("DELETE FROM RECEBE WHERE ID_RECEITA = ?", id_receita);
        return rowsAffected > 0;
    }

    public List<Recebe> getAllRecebe(){
        return jdbcTemplate.query("SELECT * FROM RECEBE", (resultSet, rowNum) -> {
            Recebe recebe = new Recebe(rowNum, rowNum);
            recebe.setMatriculaFuncionarioFarmaceutico(resultSet.getInt("MATRICULA_FARMACEUTICO"));
            recebe.setIdReceitaRecebe(resultSet.getInt("ID_RECEITA"));
            return recebe;
        });
    }

}
