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

    public boolean deleteFuncionario(int matricula) {
        jdbcTemplate.update("DELETE FROM FARMACEUTICO WHERE MATRICULA_FARMACEUTICO = ?", matricula);
        jdbcTemplate.update("DELETE FROM MEDICO WHERE MATRICULA_MEDICO = ?", matricula);

        int rowsAffected = jdbcTemplate.update("DELETE FROM FUNCIONARIO WHERE MATRICULA = ?", matricula);
    
        if (rowsAffected > 0) {
            System.out.println("Funcionário e suas dependências foram excluídos com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Funcionário ou não encontrado na base de dados.");
        }
        
        return true;
    }

    public List<Funcionario> getAllFuncionarios(){
        return jdbcTemplate.query("SELECT * FROM FUNCIONARIO", (resultSet, rowNum) -> {
            Funcionario funcionario = new Funcionario(rowNum, null, null);
            funcionario.setMatricula(resultSet.getInt("MATRICULA"));
            funcionario.setNome(resultSet.getString("NOME"));
            funcionario.setCargo(resultSet.getString("CARGO"));
            return funcionario;
        });
    }
}