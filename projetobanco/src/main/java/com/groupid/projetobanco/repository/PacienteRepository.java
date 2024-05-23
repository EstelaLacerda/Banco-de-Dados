package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Paciente;

@Repository
public class PacienteRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertPaciente(Paciente Paciente) {
            jdbcTemplate.update("INSERT INTO PACIENTE(NOME, CPF, SEXO, IDADE, PESO, NOME_MAE, DATA_NACIMENTO, CODIGO_SETOR) VALUES(?, ?, ?, ?, ?,?,?,?)",
                    Paciente.getNome(), Paciente.getCpf(), Paciente.getSexo(), Paciente.getIdade(), Paciente.getPeso(),
                    Paciente.getNomeMae(), Paciente.getDataNascimento(), Paciente.getCodigoSetorHospitalar());
            return true;   
    }

    public boolean deletePaciente(String cpf) {
        jdbcTemplate.update("DELETE FROM PACIENTE WHERE CPF = ?", cpf);

        int rowsAffected = jdbcTemplate.update("DELETE FROM PACIENTE WHERE CPF = ?", cpf);
    
        if (rowsAffected > 0) {
            System.out.println("Paciente e suas dependências foram excluídos com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Paciente ou não foi encontrado na base de dados.");
        }
        
        return true;
    }

    public List<Paciente> getAllPacientes(){
        return jdbcTemplate.query("SELECT * FROM PACIENTE", (resultSet, rowNum) -> {
            Paciente paciente = new Paciente(null, null, null, rowNum, rowNum, null, null, rowNum);
            paciente.setNome(resultSet.getString("NOME"));
            paciente.setCpf(resultSet.getString("CPF"));
            paciente.setSexo(null);
            paciente.setIdade(rowNum);
            paciente.setIdade(rowNum);
            paciente.setPeso(rowNum);
            paciente.setNomeMae(null);
            paciente.setDataNascimento(null);
            paciente.getCodigoSetorHospitalar();
            return paciente;
        });
    }

}
