package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Paciente;

@Repository
public class PacienteRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertPaciente(Paciente paciente) {
        jdbcTemplate.update("INSERT INTO PACIENTE (NOME, CPF, SEXO, IDADE, PESO, NOME_MAE, DATA_NASCIMENTO, CODIGO_SETOR, STATUS_PACIENTE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                    paciente.getNome(), paciente.getCpf(), paciente.getSexo(), paciente.getIdade(), paciente.getPeso(),
                    paciente.getNomeMae(), paciente.getDataNascimento(), paciente.getCodigoSetor(), paciente.getStatusPaciente());
        paciente.setCodigoPaciente(paciente.getCodigoPaciente());
        return true;   
    }

    public boolean deletePaciente(int codigo_paciente) {
        try {
            jdbcTemplate.update("DELETE FROM CONTEM WHERE ID_RECEITA IN (SELECT ID_RECEITA FROM RECEITA WHERE CODIGO_PACIENTE IN (SELECT CODIGO_PACIENTE FROM CONSULTA WHERE CODIGO_PACIENTE = ?))", codigo_paciente);
    
            jdbcTemplate.update("DELETE FROM RECEITA WHERE CODIGO_PACIENTE IN (SELECT CODIGO_PACIENTE FROM CONSULTA WHERE CODIGO_PACIENTE = ?)", codigo_paciente);
    
            jdbcTemplate.update("DELETE FROM CONSULTA WHERE CODIGO_PACIENTE = ?", codigo_paciente);
            
            int rowsAffected = jdbcTemplate.update("DELETE FROM PACIENTE WHERE CODIGO_PACIENTE = ?", codigo_paciente);
    
            if (rowsAffected > 0) {
                System.out.println("Paciente e suas dependências foram excluídos com sucesso.");
                return true;
            } else {
                System.out.println("Não foi possível excluir o Paciente ou não foi encontrado na base de dados.");
                return false;
            }
        } catch (DataAccessException e) {
            // Lidar com exceções de acesso a dados, se houver
            System.out.println("Erro ao excluir o Paciente: " + e.getMessage());
            return false;
        }
    }    

    public List<Paciente> getAllPacientes() {
        return jdbcTemplate.query("SELECT * FROM PACIENTE", (resultSet, rowNum) -> {
            Paciente paciente = new Paciente(null, null, null, rowNum, rowNum, null, null, rowNum, null);
            paciente.setCodigoPaciente(resultSet.getInt("CODIGO_PACIENTE"));
            paciente.setNome(resultSet.getString("NOME"));
            paciente.setCpf(resultSet.getString("CPF"));
            paciente.setSexo(resultSet.getString("SEXO"));
            paciente.setIdade(resultSet.getInt("IDADE"));
            paciente.setPeso(resultSet.getFloat("PESO"));
            paciente.setNomeMae(resultSet.getString("NOME_MAE"));
            paciente.setDataNascimento(resultSet.getDate("DATA_NASCIMENTO"));
            paciente.setCodigoSetor(resultSet.getInt("CODIGO_SETOR"));
            paciente.setStatusPaciente(resultSet.getString("STATUS_PACIENTE"));
            return paciente;
        });
    }

    public List<Paciente> getAllPacientesMaiorDeIdade() {
        return jdbcTemplate.query("SELECT * FROM PACIENTE P WHERE P.IDADE > 18", (resultSet, rowNum) -> {
            Paciente paciente = new Paciente(null, null, null, rowNum, rowNum, null, null, rowNum, null);
            paciente.setCodigoPaciente(resultSet.getInt("CODIGO_PACIENTE"));
            paciente.setNome(resultSet.getString("NOME"));
            paciente.setCpf(resultSet.getString("CPF"));
            paciente.setSexo(resultSet.getString("SEXO"));
            paciente.setIdade(resultSet.getInt("IDADE"));
            paciente.setPeso(resultSet.getFloat("PESO"));
            paciente.setNomeMae(resultSet.getString("NOME_MAE"));
            paciente.setDataNascimento(resultSet.getDate("DATA_NASCIMENTO"));
            paciente.setCodigoSetor(resultSet.getInt("CODIGO_SETOR"));
            paciente.setStatusPaciente(resultSet.getString("STATUS_PACIENTE"));
            return paciente;
        });
    }

    public List<Paciente> getAllPacientesMenorDeIdade() {
        return jdbcTemplate.query("SELECT * FROM PACIENTE P WHERE P.IDADE < 18", (resultSet, rowNum) -> {
            Paciente paciente = new Paciente(null, null, null, rowNum, rowNum, null, null, rowNum, null);
            paciente.setCodigoPaciente(resultSet.getInt("CODIGO_PACIENTE"));
            paciente.setNome(resultSet.getString("NOME"));
            paciente.setCpf(resultSet.getString("CPF"));
            paciente.setSexo(resultSet.getString("SEXO"));
            paciente.setIdade(resultSet.getInt("IDADE"));
            paciente.setPeso(resultSet.getFloat("PESO"));
            paciente.setNomeMae(resultSet.getString("NOME_MAE"));
            paciente.setDataNascimento(resultSet.getDate("DATA_NASCIMENTO"));
            paciente.setCodigoSetor(resultSet.getInt("CODIGO_SETOR"));
            paciente.setStatusPaciente(resultSet.getString("STATUS_PACIENTE"));
            return paciente;
        });
    }

    public boolean updatePaciente(Paciente paciente) {
        int rowsAffected = jdbcTemplate.update("UPDATE PACIENTE SET NOME = ?, CPF = ?, SEXO = ?, IDADE = ?, PESO = ?, NOME_MAE = ?, DATA_NASCIMENTO = ?, CODIGO_SETOR = ?, STATUS_PACIENTE = ? WHERE CODIGO_PACIENTE = ?",
            paciente.getNome(), paciente.getCpf(), paciente.getSexo(), paciente.getIdade(), paciente.getPeso(),
            paciente.getNomeMae(), paciente.getDataNascimento(), paciente.getCodigoSetor(), paciente.getStatusPaciente(), paciente.getCodigoPaciente());
        return rowsAffected > 0;
    }
}
