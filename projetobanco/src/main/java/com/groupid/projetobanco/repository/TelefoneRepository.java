package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.groupid.projetobanco.models.Telefone; 

@Repository
public class TelefoneRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertTelefone(Telefone telefone) {
        String sql = "INSERT INTO TELEFONE (COD_PACIENTE, NUMERO) VALUES (?, ?)";
        jdbcTemplate.update(sql, telefone.getCodPaciente(), telefone.getNumero());
        return true;
    }

    public boolean deleteTelefone(int id) { 
        int rowsAffected = jdbcTemplate.update("DELETE FROM TELEFONE WHERE ID = ?", id);

        if (rowsAffected > 0) {
            System.out.println("Telefone excluído com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o telefone ou não foi encontrado na base de dados.");
        }

        return rowsAffected > 0;
    }

    public List<Telefone> getAllTelefones() { 
        return jdbcTemplate.query("SELECT * FROM TELEFONE", (resultSet, rowNum) -> {
            Telefone telefone = new Telefone(rowNum, rowNum, null); 
            telefone.setId(resultSet.getInt("ID")); 
            telefone.setCodPaciente(resultSet.getInt("COD_PACIENTE")); 
            telefone.setNumero(resultSet.getString("NUMERO")); 
            return telefone;
        });
    }

    public boolean updateTelefone(Telefone telefone) {
        int rowsAffected = jdbcTemplate.update(
            "UPDATE TELEFONE SET COD_PACIENTE = ?, NUMERO = ? WHERE ID = ?",
            telefone.getCodPaciente(), telefone.getNumero(), telefone.getId()
        );
        return rowsAffected > 0;
    }


}
