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
        jdbcTemplate.update("INSERT INTO FARMACEUTICO(CRF, MATRICULA_FARMACEUTICO) VALUES(?, ?)", 
        farmaceutico.getCrf(), farmaceutico.getMatriculaFarmaceutico());
        return true;
    }

    public boolean deleteFarmaceutico(int matricula_farmaceutico){

        int rowsAffected = jdbcTemplate.update("DELETE FROM FARMACEUTICO WHERE MATRICULA_FARMACEUTICO = ?", matricula_farmaceutico);
        return rowsAffected > 0;
    }

    public List<Farmaceutico> getAllFarmaceuticos(){
        return jdbcTemplate.query(
            "SELECT F.MATRICULA, F.NOME, FA.CRF FROM FARMACEUTICO FA INNER JOIN FUNCIONARIO F ON FA.MATRICULA_FARMACEUTICO = F.MATRICULA",
            (resultSet, rowNum) -> {
                Farmaceutico farmaceutico = new Farmaceutico(null, null, null, rowNum);
                farmaceutico.setMatricula(resultSet.getInt("MATRICULA"));
                farmaceutico.setNome(resultSet.getString("NOME"));
                farmaceutico.setCrf(resultSet.getString("CRF"));
                return farmaceutico;
            });
    }
    
}