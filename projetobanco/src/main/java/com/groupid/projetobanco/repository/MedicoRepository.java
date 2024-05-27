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

    public boolean insertMedico(Medico medico) {
        if (funcionarioExists(medico.getMatricula_Medico())) {
            int rowsMedico = jdbcTemplate.update(
                "INSERT INTO MEDICO(CRM, MATRICULA_MEDICO) VALUES(?, ?)",
                medico.getCrm(), medico.getMatricula_Medico()
            );
            return rowsMedico > 0;
        } else {
            return false;
        }
    }

    private boolean funcionarioExists(int matricula) {
        String sql = "SELECT COUNT(*) FROM FUNCIONARIO WHERE MATRICULA = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, matricula) > 0;
    }

    public boolean deleteMedico(int matricula_medico) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM MEDICO WHERE MATRICULA_MEDICO = ?", matricula_medico);
        return rowsAffected > 0;
    }

    public List<Medico> getAllMedicos(){
        return jdbcTemplate.query(
            "SELECT F.MATRICULA, F.NOME, M.CRM FROM MEDICO M INNER JOIN FUNCIONARIO F ON M.MATRICULA_MEDICO = F.MATRICULA",
            (resultSet, rowNum) -> {
                Medico medico = new Medico(rowNum, null, null, null, rowNum);
                medico.setMatricula(resultSet.getInt("MATRICULA"));
                medico.setNome(resultSet.getString("NOME"));
                medico.setCrm(resultSet.getString("CRM"));
                return medico;
            });
    }
    
}