package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Consumo_mensal;

@Repository
public class ConsumoMensalRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertConsumoMensal(Consumo_mensal consumoMensal) {
        jdbcTemplate.update("INSERT INTO CONSUMO_MENSAL (CODIGO_REMEDIO, MES, CONSUMO_MENSAL, UNIDADE_MEDIDA, CONSUMO_MENSAL_MEDIO) VALUES (?, ?, ?, ?, ?)",
            consumoMensal.getCodigoRemedio(), consumoMensal.getMes(), consumoMensal.getConsumoMensal(), consumoMensal.getUnidadeMedida(), consumoMensal.getConsumoMensalMedio());
    }

    public boolean deleteConsumoMensal(int codigo_consumo_mensal) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM CONSUMO_MENSAL WHERE CODIGO_CONSUMO_MENSAL = ?", 
            codigo_consumo_mensal);
        return rowsAffected > 0;
    }

    public List<Consumo_mensal> getAllConsumoMensal() {
        return jdbcTemplate.query("SELECT * FROM CONSUMO_MENSAL", (resultSet, rowNum) -> {
            Consumo_mensal consumoMensal = new Consumo_mensal(rowNum, rowNum, null, rowNum, null, rowNum);
            consumoMensal.setCondigoConsumoMensal(resultSet.getInt("CODIGO_CONSUMO_MENSAL"));
            consumoMensal.setCodigoRemedio(resultSet.getInt("CODIGO_REMEDIO"));
            consumoMensal.setMes(resultSet.getString("MES"));
            consumoMensal.setConsumoMensal(resultSet.getDouble("CONSUMO_MENSAL"));
            consumoMensal.setUnidadeMedida(resultSet.getString("UNIDADE_MEDIDA"));
            consumoMensal.setConsumoMensalMedio(resultSet.getDouble("CONSUMO_MENSAL_MEDIO"));
            return consumoMensal;
        });
    }

    public boolean updateConsumoMensal(Consumo_mensal consumoMensal) {
        int rowsAffected = jdbcTemplate.update("UPDATE CONSUMO_MENSAL SET CODIGO_REMEDIO = ?, MES = ?, CONSUMO_MENSAL = ?, UNIDADE_MEDIDA = ?, CONSUMO_MENSAL_MEDIO = ? WHERE CODIGO_CONSUMO_MENSAL = ?",
            consumoMensal.getCodigoRemedio(), consumoMensal.getMes(), consumoMensal.getConsumoMensal(), consumoMensal.getUnidadeMedida(), consumoMensal.getConsumoMensalMedio(), consumoMensal.getCodigoConsumoMensal());
        return rowsAffected > 0;
    }
}
