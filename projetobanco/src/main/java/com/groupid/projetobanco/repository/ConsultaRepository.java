package com.groupid.projetobanco.repository;

import java.sql.Time;
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
        jdbcTemplate.update("INSERT INTO CONSULTA VALUES(?, ?, ?)",
        consulta.getHora(), consulta.getCpfPaciente(), consulta.getMatriculaFuncionarioMedico());
    }

    public boolean deleteConsulta(int matricula_medico, String cpf_Paciente, Time hora ){

        int rowsAffected = jdbcTemplate.update("DELETE FROM CONSULTA WHERE MATRICULA_MEDICO = ? AND CPF_PACIENTE = ? AND HORA= ?", matricula_medico, cpf_Paciente, hora);
        return rowsAffected > 0;
    }

    public List<Consulta> getAllConsultas(){
        return jdbcTemplate.query("SELECT * FROM CONSULTA", (resultSet, rowNum) -> {
            Consulta consulta = new Consulta(null, null, rowNum);
            consulta.setCpfPaciente(null);
            consulta.setMatriculaFuncionarioMedico(rowNum);
            consulta.setHora(null);
            return consulta;
        });
    }
}