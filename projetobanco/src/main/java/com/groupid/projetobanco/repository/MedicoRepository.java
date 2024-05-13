package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Medico;

@Repository
public class MedicoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertMedico(Medico medico) {
        jdbcTemplate.update("INSERT INTO MEDICO(CRM, MATRICULA_MEDICO) VALUES(?, ?)",
        medico.getCrm(), medico.getMatriculaMedico());
    }

    public boolean deleteMedico(int matricula_medico){

        int rowsAffected = jdbcTemplate.update("DELETE FROM MEDICO WHERE MATRICULA_MEDICO = ?", matricula_medico);
        return rowsAffected > 0;
    }

    public List<Medico> getAllMedicos(){
        return jdbcTemplate.query("SELECT * FROM MEDICO", (resultSet, rowNum) -> {
            Medico medico = new Medico(null, rowNum);
            medico.setCrm(resultSet.getString("CRM"));
            medico.setMatriculaMedico(resultSet.getInt("MATRICULA_MEDICO"));
            return medico;
        });
    }
}