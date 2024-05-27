package com.groupid.projetobanco.repository;

import java.sql.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Estoque;

@Repository
public class EstoqueRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateEstoque(Estoque estoque){
        jdbcTemplate.update("UPDATE ESTOQUE SET UNIDADES = ?, QUANTIDADE_DE_REMEDIOS = ?, DATA_ULTIMA_ATUALIZACAO = ?, NOME_REMEDIO = ?, UNIDADE_MEDIDA = ?, STATUS_ESTOQUE = ?, DATA_DE_VALIDADE = ? WHERE COD_ESTOQUE = ?",
        estoque.getUnidades(), estoque.getQuantidadeDeRemedios(), estoque.getDataUltimaAtualizacao(), 
        estoque.getNome_Remedio(), estoque.getUnidade_Medida(), estoque.getStatusEstoque(), estoque.getDataValidade(), estoque.getCodigoEstoque());
    }

    public boolean insertEstoque(Estoque estoque) {
        int rowsAffected = jdbcTemplate.update(
            "INSERT INTO ESTOQUE (UNIDADES, QUANTIDADE_DE_REMEDIOS, NOME_REMEDIO, UNIDADE_MEDIDA, DATA_DE_VALIDADE) VALUES (?, ?, ?, ?, ?)",
            estoque.getUnidades(), estoque.getQuantidadeDeRemedios(), estoque.getNome_Remedio(), estoque.getUnidade_Medida(), Date.valueOf(estoque.getDataValidade())
        );
        return rowsAffected > 0;
    }
    
    public boolean deleteEstoque(int cod_estoque){
        int rowsAffected = jdbcTemplate.update("DELETE FROM ESTOQUE WHERE COD_ESTOQUE = ?", cod_estoque);
        if (rowsAffected > 0) {
            System.out.println("Estoque e suas dependências foram excluídas com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Estoque ou não foi encontrado na base de dados.");
        }
        return rowsAffected > 0;
    }

    public List<Estoque> getAllEstoques() {
        return jdbcTemplate.query("SELECT * FROM ESTOQUE", (resultSet, rowNum) -> {
            Estoque estoque = new Estoque(rowNum, rowNum, rowNum, null, null, null, null, null);
            estoque.setCodigoEstoque(resultSet.getInt("COD_ESTOQUE"));
            estoque.setUnidades(resultSet.getInt("UNIDADES"));
            estoque.setQuantidadeDeRemedios(resultSet.getInt("QUANTIDADE_DE_REMEDIOS"));
            estoque.setDataUltimaAtualizacao(resultSet.getTimestamp("DATA_ULTIMA_ATUALIZACAO"));
            estoque.setNome_Remedio(resultSet.getString("NOME_REMEDIO"));
            estoque.setUnidade_Medida(resultSet.getString("UNIDADE_MEDIDA"));
            estoque.setStatusEstoque(resultSet.getString("STATUS_ESTOQUE"));
            Date dataValidade = resultSet.getDate("DATA_DE_VALIDADE");
            estoque.setDataValidade(dataValidade != null ? dataValidade.toLocalDate() : null);
            return estoque;
        });
    }
}
