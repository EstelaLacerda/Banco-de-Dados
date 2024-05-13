package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Farmaceutico;

@Repository
public class FarmaceuticoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertFarmaceutico(Farmaceutico farmaceutico) {
        jdbcTemplate.update("INSERT INTO FARMACEUTICO(CRF, MATRICULA_FARMACEUTICO) VALUES(?, ?)",
        farmaceutico.getCrf(), farmaceutico.getMatriculaFarmaceutico());
    }

    public boolean deleteFarmaceutico(int matricula_farmaceutico){

        int rowsAffected = jdbcTemplate.update("DELETE FROM FARMACEUTICO WHERE MATRICULA_FARMACEUTICO = ?", matricula_farmaceutico);
        return rowsAffected > 0;
    }

    public List<Farmaceutico> getAllFarmaceuticos(){
        return jdbcTemplate.query("SELECT * FROM FARMACEUTICO", (resultSet, rowNum) -> {
            Farmaceutico farmaceutico = new Farmaceutico(null, rowNum);
            farmaceutico.setCrf(resultSet.getString("CRF"));
            farmaceutico.setMatriculaFarmaceutico(resultSet.getInt("MATRICULA_FARMACEUTICO"));
            return farmaceutico;
        });
    }
}