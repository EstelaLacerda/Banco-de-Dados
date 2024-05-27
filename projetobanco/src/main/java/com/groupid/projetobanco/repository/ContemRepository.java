package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Contem;

@Repository
public class ContemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertContem(Contem contem) {
        jdbcTemplate.update("INSERT INTO CONTEM(ID_RECEITA, CODIGO_REMEDIO) VALUES(?, ?)",
        contem.getIdReceita(), contem.getContemCodigoRemedio());
    }

    public boolean deleteContem(int id_receita, int codigo_remedio){

        int rowsAffected = jdbcTemplate.update("DELETE FROM CONTEM WHERE ID_RECEITA = ? AND CODIGO_REMEDIO = ? ", id_receita, codigo_remedio);
        return rowsAffected > 0;
    }

    public List<Contem> getAllContem(){
        return jdbcTemplate.query("SELECT * FROM CONTEM", (resultSet, rowNum) -> {
            Contem contem = new Contem(rowNum, rowNum);
            contem.setIdReceita(resultSet.getInt("ID_RECEITA"));
            contem.setContemCodigoRemedio(resultSet.getInt("CODIGO_REMEDIO"));
            return contem;
        });
    }

}