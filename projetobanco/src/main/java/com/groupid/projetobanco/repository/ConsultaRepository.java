package com.groupid.projetobanco.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Consulta;

@Repository
public class ConsultaRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertConsulta(Consulta consulta) {
        jdbcTemplate.update("INSERT INTO CONSULTA (CODIGO_PACIENTE, MATRICULA_MEDICO) VALUES(?, ?)",
        consulta.getCodigoPaciente(), consulta.getMatriculaFuncionarioMedico());
    }

    public boolean deleteConsulta(Timestamp data_hora, int codigo_paciente , int matricula_medico ){

        int rowsAffected = jdbcTemplate.update("DELETE FROM CONSULTA WHERE DATA_HORA= ? AND CODIGO_PACIENTE = ? AND MATRICULA_MEDICO = ? ", data_hora, codigo_paciente, matricula_medico);
        return rowsAffected > 0;
    }

    public List<Consulta> getAllConsultas(){
        return jdbcTemplate.query("SELECT * FROM CONSULTA", (resultSet, rowNum) -> {
            Consulta consulta = new Consulta(null, rowNum, rowNum);
            consulta.setDataHora(resultSet.getTimestamp("DATA_HORA"));
            consulta.setCodigoPaciente(resultSet.getInt("CODIGO_PACIENTE"));
            consulta.setMatriculaFuncionarioMedico(resultSet.getInt("MATRICULA_MEDICO"));
            return consulta;
        });
    }

}