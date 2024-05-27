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

    public void updateRemedio(Remedio remedio){
        jdbcTemplate.update("UPDATE INTO REMEDIO(CODIGO, NOME_DO_REMEDIO, PRINCIPIO_ATIVO, TIPO, QUANTIDADE, UNIDADE_MEDIDA, DOSAGEM, COD_ESTOQUE, CONTROLADO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
        remedio.getCodigo(), remedio.getNomeRemedio(), remedio.getPrincipioAtivo(), remedio.getTipo(), remedio.getQuantidade(), 
        remedio.getUnidadeMedida(), remedio.getDosagem(),remedio.getCodEstoque(), remedio.getControlado()
        );
    }

    public boolean insertRemedio(Remedio remedio) {
        int rowsAffected = jdbcTemplate.update(
            "INSERT INTO REMEDIO(CODIGO, NOME_DO_REMEDIO, PRINCIPIO_ATIVO, TIPO, QUANTIDADE, UNIDADE_MEDIDA, DOSAGEM, COD_ESTOQUE, CONTROLADO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
            remedio.getCodigo(), remedio.getNomeRemedio(), remedio.getPrincipioAtivo(), remedio.getTipo(), remedio.getQuantidade(), 
            remedio.getUnidadeMedida(), remedio.getDosagem(),remedio.getCodEstoque(), remedio.getControlado()
        );
        return rowsAffected > 0;
    }

    public boolean deleteRemedio(int codigo){

        int rowsAffected = jdbcTemplate.update("DELETE FROM REMEDIO WHERE CODIGO = ?", codigo);
        if (rowsAffected > 0) {
            System.out.println("Remédio e suas dependências foram excluídos com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Remédio ou não foi encontrado na base de dados.");
        }

        return true;

    }

    public List<Remedio> getAllRemedios() {
        return jdbcTemplate.query("SELECT * FROM REMEDIO", (resultSet, rowNum) -> {
            Remedio remedio = new Remedio(rowNum, null, null, null, null, null, null, rowNum, false);
            remedio.setCodigo(resultSet.getInt("CODGIO")); 
            remedio.setNomeRemedio(resultSet.getString("NOME_DO_REMEDIO"));    
            remedio.setPrincipioAtivo(resultSet.getString("PRINCIPIO_ATIVO")); 
            remedio.setTipo(resultSet.getString("TIPO"));
            remedio.setQuantidade(resultSet.getString("QUANTIDADE"));
            remedio.setUnidadeMedida(resultSet.getString("UNIDADE_MEDIDA"));
            remedio.setDosagem(resultSet.getString("DOSAGEM"));
            remedio.setCodEstoque(resultSet.getInt("COD_ESTOQUE"));
            remedio.setControlado(resultSet.getBoolean("CONTROLADO"));
            return remedio;
        });
    }
}