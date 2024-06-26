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

    public boolean insertFuncionario(Funcionario funcionario) {
        jdbcTemplate.update("INSERT INTO FUNCIONARIO(NOME, CARGO) VALUES(?, ?)", 
        funcionario.getNome(), funcionario.getCargo());
        funcionario.setMatricula(funcionario.getMatricula());
        return true;
    }

    public boolean deleteFuncionario(int matricula) {
        jdbcTemplate.update("DELETE FROM FARMACEUTICO WHERE MATRICULA_FARMACEUTICO = ?", matricula);
        jdbcTemplate.update("DELETE FROM MEDICO WHERE MATRICULA_MEDICO = ?", matricula);
    
        int rowsAffected = jdbcTemplate.update("DELETE FROM FUNCIONARIO WHERE MATRICULA = ?", matricula);
        
        if (rowsAffected > 0) {
            System.out.println("Funcionário e suas dependências foram excluídas com sucesso.");
            return true;
        } else {
            System.out.println("Não foi possível excluir o Funcionário ou não foi encontrado na base de dados.");
            return false;
        }
    }
    

    public List<Funcionario> getAllFuncionarios(){
        return jdbcTemplate.query("SELECT * FROM FUNCIONARIO", (resultSet, rowNum) -> {
            Funcionario funcionario = new Funcionario(null, null);
            funcionario.setMatricula(resultSet.getInt("MATRICULA"));
            funcionario.setNome(resultSet.getString("NOME"));
            funcionario.setCargo(resultSet.getString("CARGO"));
            return funcionario;
        });
    }

    public List<Funcionario> getAllFuncionariosOutro() {
        String sql = "SELECT * FROM FUNCIONARIO WHERE CARGO NOT IN ('Médico', 'Farmacêutico')";
        
        return jdbcTemplate.query(sql, (resultSet, rowNum) -> {
            Funcionario funcionario = new Funcionario(null, null);
            funcionario.setMatricula(resultSet.getInt("MATRICULA"));
            funcionario.setNome(resultSet.getString("NOME"));
            funcionario.setCargo(resultSet.getString("CARGO"));
            return funcionario;
        });
    }
    
    public int getLastMatricula() {
        return jdbcTemplate.queryForObject("SELECT MAX(MATRICULA) FROM FUNCIONARIO", Integer.class);
    }
}