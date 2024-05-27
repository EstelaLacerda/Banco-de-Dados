package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.RemedioControlado;

@Repository
public class ReceitaControleEspecialRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertRemedioControlado(RemedioControlado remedio_controlado) {
        jdbcTemplate.update("INSERT INTO REMEDIO_CONTROLADO(FOI_APROVADO, CRF, CODIGO_REMEDIO) VALUES (?, ?, ?)",
        remedio_controlado.getFoi_Aprovado(), remedio_controlado.getCrf(), remedio_controlado.getCodigoRemedio());
    }

    public boolean deleteRemedioControlado(int codigo_remedio){
        int rowsAffected = jdbcTemplate.update("DELETE FROM REMEDIO_CONTROLADO WHERE FK_REMEDIO_CODIGO = ?", codigo_remedio);
        if(rowsAffected > 0){
            System.out.println("Remédio controlado foi excluído com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Remédio controlado ou não foi encontrado na base de dados.");
        }

        return true;

    }

    public List<RemedioControlado> getAllRemediosControlados() {
        return jdbcTemplate.query("SELECT * FROM REMEDIO_CONTROLADO", (resultSet, rowNum) -> {
            RemedioControlado remedioControlado = new RemedioControlado(false, null, rowNum);
            remedioControlado.setFoi_Aprovado(resultSet.getBoolean("FOI_APROVADO"));
            remedioControlado.setCrf(resultSet.getString("CRF"));
            remedioControlado.setCodigoRemedio(resultSet.getInt("CODIGO_REMEDIO"));
            return remedioControlado;
        });

    }

}
