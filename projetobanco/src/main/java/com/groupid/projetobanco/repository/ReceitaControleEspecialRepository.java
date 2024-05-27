package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Receita_controle_especial;

@Repository
public class ReceitaControleEspecialRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertReceitaControleEspecial(Receita_controle_especial receita_controle_especial) {
        jdbcTemplate.update("INSERT INTO RECEITA_CONTROLE_ESPECIAL (FOI_APROVADO, CRF, ID_RECEITA) VALUES (?, ?, ?)",
        receita_controle_especial.getFoiAprovado(), receita_controle_especial.getCrf(), receita_controle_especial.getIdReceita());
    }

    public boolean deleteReceitaControleEspecial(int id_receita) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM RECEITA_CONTROLE_ESPECIAL WHERE ID_RECEITA = ?", id_receita);
        if(rowsAffected > 0){
            System.out.println("Receita controle especial foi excluída com sucesso.");
        } else {
            System.out.println("Não foi possível excluir a Receita controle especial ou não foi encontrada na base de dados.");
        }
        return rowsAffected > 0;
    }

    public List<Receita_controle_especial> getAllReceitasControleEspecial() {
        return jdbcTemplate.query("SELECT * FROM RECEITA_CONTROLE_ESPECIAL", (resultSet, rowNum) -> {
            Receita_controle_especial receitaControleEspecial = new Receita_controle_especial(false, null, rowNum);
            receitaControleEspecial.setFoiAprovado(resultSet.getBoolean("FOI_APROVADO"));
            receitaControleEspecial.setCrf(resultSet.getString("CRF"));
            receitaControleEspecial.setIdReceita(resultSet.getInt("ID_RECEITA"));
            return receitaControleEspecial;
        });
    }

    public boolean updateReceitaControleEspecial(Receita_controle_especial receita_controle_especial) {
        int rowsAffected = jdbcTemplate.update("UPDATE RECEITA_CONTROLE_ESPECIAL SET FOI_APROVADO = ?, CRF = ? WHERE ID_RECEITA = ?",
            receita_controle_especial.getFoiAprovado(), receita_controle_especial.getCrf(), receita_controle_especial.getIdReceita());
        return rowsAffected > 0;
    }
}
