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

    public boolean insertFarmaceutico(Farmaceutico farmaceutico) {
        if (!farmaceuticoExists(farmaceutico.getMatriculaFarmaceutico())) {
            jdbcTemplate.update("INSERT INTO FARMACEUTICO(CRF, MATRICULA_FARMACEUTICO) VALUES(?, ?)",
                    farmaceutico.getCrf(), farmaceutico.getMatriculaFarmaceutico());
            System.out.println("Farmacêutico inserido com sucesso!");
            return true;
        } else {
            System.out.println("Já existe um farmacêutico com essa matrícula.");
            return false;
        }

    }

    public boolean farmaceuticoExists(int matricula_farmaceutico) {
        String sql = "SELECT COUNT(*) FROM FARMACEUTICO WHERE MATRICULA_FARMACEUTICO = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, matricula_farmaceutico) > 0;
    }

    public boolean deleteFarmaceutico(int matricula_farmaceutico){

        int rowsAffected = jdbcTemplate.update("DELETE FROM FARMACEUTICO WHERE MATRICULA_FARMACEUTICO = ?", matricula_farmaceutico);
        return rowsAffected > 0;
    }

    public List<Farmaceutico> getAllFarmaceuticos() {
        return jdbcTemplate.query("SELECT * FROM FARMACEUTICO", (resultSet, rowNum) -> {
            Farmaceutico farmaceutico = new Farmaceutico(
                resultSet.getString("CRF"),
                resultSet.getInt("MATRICULA_FARMACEUTICO")
            );
            return farmaceutico;
        });
    }
    
}