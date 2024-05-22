package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Setor_hospitalar;

@Repository
public class SetorHospitalarRepository {

    @Autowired
    private static JdbcTemplate jdbcTemplate;

    public static boolean insertSetorHospitalar(Setor_hospitalar Setor_hospitalar) {
            jdbcTemplate.update("INSERT INTO SETOR_HOSPITALAR(CODIGO_SETOR) VALUES(?)", Setor_hospitalar.getCodigoSetor());
            return true;   
    }

    public static boolean deleteSetorHospitalar(int codigo_Setor) {
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
            Setor_hospitalar setor_hospitalar = new Setor_hospitalar(rowNum);
            setor_hospitalar.setCodigoSetor(resultSet.getInt("CODIGO_SETOR"));
            return setor_hospitalar;
        });
    }

}

