package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Funcionario;

@Repository
public class FuncionarioRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertFuncionario(Funcionario funcionario) {
        jdbcTemplate.update("INSERT INTO FUNCIONARIO(MATRICULA, NOME, CARGO) VALUES(?, ?, ?)",
        funcionario.getMatricula(), funcionario.getNome(), funcionario.getCargo());
    }

    public boolean deleteFuncionario(int matricula){

        jdbcTemplate.update("DELETE FROM farmaceutico WHERE FK_FUNCIONARIO_MATRICULA_FARMACEUTICO = ?", matricula);
        jdbcTemplate.update("DELETE FROM medico WHERE FK_FUNCIONARIO_MATRICULA_MEDICO = ?", matricula);

        int rowsAffected = jdbcTemplate.update("DELETE FROM FUNCIONARIO WHERE MATRICULA = ?", matricula);
        return rowsAffected > 0;
    }

    public List<Funcionario> getAllFuncionarios(){
        return jdbcTemplate.query("SELECT * FROM FUNCIONARIO", (resultSet, rowNum) -> {
            Funcionario funcionario = new Funcionario(rowNum, null, null);
            funcionario.setMatricula(resultSet.getInt("MATRICULA"));
            return funcionario;
        });
    }
}