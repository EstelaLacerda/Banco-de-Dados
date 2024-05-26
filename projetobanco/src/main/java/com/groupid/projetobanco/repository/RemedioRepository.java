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
        jdbcTemplate.update("UPDATE INTO REMEDIO(VALIDADE, QUANTIDADE, CODIGO, TIPO, DATA_ABERTURA, TEMPO_UTILIZACAO, COD_ESTOQUE, PRINCIPIO_ATIVO, NOME_DO_REMEDIO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
        remedio.getValidade(), remedio.getQuantidade(), remedio.getCodigo(), remedio.getTipo(), 
        remedio.getData_abertura(), remedio.getTempoUtilizacao(), remedio.getCodEstoque(), remedio.getPrincipioAtivo(),
        remedio.getNome_do_Remedio());
    }

    public void insertRemedio(Remedio remedio) {
        jdbcTemplate.update("INSERT INTO REMEDIO(VALIDADE, QUANTIDADE, CODIGO, TIPO, DATA_ABERTURA, TEMPO_UTILIZACAO, COD_ESTOQUE, PRINCIPIO_ATIVO, NOME_DO_REMEDIO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
        remedio.getValidade(), remedio.getQuantidade(), remedio.getCodigo(), remedio.getTipo(), 
        remedio.getData_abertura(), remedio.getTempoUtilizacao(), remedio.getCodEstoque(), remedio.getPrincipioAtivo(), 
        remedio.getNome_do_Remedio());
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
            Remedio remedio = new Remedio();
            remedio.setValidade(resultSet.getDate("VALIDADE"));
            remedio.setQuantidade(resultSet.getString("QUANTIDADE"));
            remedio.setCodigo(resultSet.getInt("CODIGO"));
            remedio.setTipo(resultSet.getString("TIPO"));
            remedio.setData_abertura(resultSet.getDate("DATA_ABERTURA"));
            remedio.setTempoUtilizacao(resultSet.getString("TEMPO_UTILIZACAO"));
            remedio.setCodEstoque(resultSet.getInt("COD_ESTOQUE"));
            remedio.setPrincipioAtivo(resultSet.getString("PRINCIPIO_ATIVO"));
            remedio.setNome_do_Remedio(resultSet.getString("NOME_DO_REMEDIO"));
            return remedio;
        });
    }
}