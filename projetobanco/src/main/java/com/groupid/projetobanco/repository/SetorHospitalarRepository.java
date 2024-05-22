package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Setor_hospitalar;

@Repository
public class SetorHospitalarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    public boolean insertSetorHospitalar(Setor_hospitalar Setor_hospitalar) {

        try {
            String sql = "INSERT INTO SETOR_HOSPITALAR(CODIGO_SETOR, NOME_DO_SETOR) VALUES(?,?)";
            jdbcTemplate.update(sql, Setor_hospitalar.getCodigoSetor(), Setor_hospitalar.getNomeDoSetor());
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao inserir setor hospitalar " + e.getMessage(), e);
        }
            return true;   
    }

    public boolean deleteSetorHospitalar(int codigo_Setor) {
        jdbcTemplate.update("DELETE FROM SETOR_HOSPITALAR WHERE CODIGO_SETOR = ?", codigo_Setor);

        int rowsAffected = jdbcTemplate.update("DELETE FROM SETOR_HOSPITLAR WHERE CODIGO_SETOR = ?", codigo_Setor);
    
        if (rowsAffected > 0) {
            System.out.println("Setor Hospitalar e suas dependências foram excluídos com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Setor Hospitalar ou não foi encontrado na base de dados.");
        }
        
        return true;
    }

    public List<Setor_hospitalar> getAllSetoresHospilar(){
        return jdbcTemplate.query("SELECT * FROM SETOR_HOSPITALAR", (resultSet, rowNum) -> {
            Setor_hospitalar Setor_hospitalar = new Setor_hospitalar(rowNum, null);
            Setor_hospitalar.setCodigoSetor(resultSet.getInt("CODIGO_SETOR"));
            Setor_hospitalar.setNomeDoSetor(resultSet.getString("NOME_DO_SETOR"));
            return Setor_hospitalar;
        });
    }

}

