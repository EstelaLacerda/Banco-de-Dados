package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Remedio;

@Repository
public class RemedioRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertRemedio(Remedio remedio) {
        int rowsAffected = jdbcTemplate.update(
            "INSERT INTO REMEDIO(NOME, PRINCIPIO_ATIVO, TIPO, QUANTIDADE, UNIDADE_MEDIDA, DOSAGEM, COD_ESTOQUE, CONTROLADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
            remedio.getNomeRemedio(), remedio.getPrincipioAtivo(), remedio.getTipo(), remedio.getQuantidade(), 
            remedio.getUnidadeMedida(), remedio.getDosagem(), remedio.getCodEstoque(), remedio.getControlado()
        );
        remedio.setCodigo(remedio.getCodigo());
        return rowsAffected > 0;
    }

    public boolean deleteRemedio(int codigo) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM REMEDIO WHERE CODIGO_REMEDIO = ?", codigo);
        if (rowsAffected > 0) {
            System.out.println("Remédio e suas dependências foram excluídos com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Remédio ou não foi encontrado na base de dados.");
        }
        return rowsAffected > 0;
    }

    public List<Remedio> getAllRemedios() {
        return jdbcTemplate.query("SELECT * FROM REMEDIO", (resultSet, rowNum) -> {
            Remedio remedio = new Remedio(null, null, null, rowNum, null, null, rowNum, false);
            remedio.setCodigo(resultSet.getInt("CODIGO_REMEDIO")); 
            remedio.setNomeRemedio(resultSet.getString("NOME"));    
            remedio.setPrincipioAtivo(resultSet.getString("PRINCIPIO_ATIVO")); 
            remedio.setTipo(resultSet.getString("TIPO"));
            remedio.setQuantidade(resultSet.getInt("QUANTIDADE"));
            remedio.setUnidadeMedida(resultSet.getString("UNIDADE_MEDIDA"));
            remedio.setDosagem(resultSet.getString("DOSAGEM"));
            remedio.setCodEstoque(resultSet.getInt("COD_ESTOQUE"));
            remedio.setControlado(resultSet.getBoolean("CONTROLADO"));
            return remedio;
        });
    }

    public void updateRemedio(Remedio remedio) {
        jdbcTemplate.update(
            "UPDATE REMEDIO SET NOME = ?, PRINCIPIO_ATIVO = ?, TIPO = ?, QUANTIDADE = ?, UNIDADE_MEDIDA = ?, DOSAGEM = ?, COD_ESTOQUE = ?, CONTROLADO = ? WHERE CODIGO_REMEDIO = ?",
            remedio.getNomeRemedio(), remedio.getPrincipioAtivo(), remedio.getTipo(), remedio.getQuantidade(), 
            remedio.getUnidadeMedida(), remedio.getDosagem(), remedio.getCodEstoque(), remedio.getControlado(), remedio.getCodigo()
        );
    }

    public List<Remedio> getAllRemediosPrincipioAtivoClonazepam() {
        return jdbcTemplate.query("SELECT * FROM REMEDIO WHERE NOME IN (SELECT NOME_REMEDIO FROM ESTOQUE WHERE NOME_REMEDIO = 'Clonazepam')", (resultSet, rowNum) -> {
            Remedio remedio = new Remedio(null, null, null, rowNum, null, null, rowNum, false);
            remedio.setCodigo(resultSet.getInt("CODIGO_REMEDIO")); 
            remedio.setNomeRemedio(resultSet.getString("NOME"));    
            remedio.setPrincipioAtivo(resultSet.getString("PRINCIPIO_ATIVO")); 
            remedio.setTipo(resultSet.getString("TIPO"));
            remedio.setQuantidade(resultSet.getInt("QUANTIDADE"));
            remedio.setUnidadeMedida(resultSet.getString("UNIDADE_MEDIDA"));
            remedio.setDosagem(resultSet.getString("DOSAGEM"));
            remedio.setCodEstoque(resultSet.getInt("COD_ESTOQUE"));
            remedio.setControlado(resultSet.getBoolean("CONTROLADO"));
            return remedio;
        });
    }
}
