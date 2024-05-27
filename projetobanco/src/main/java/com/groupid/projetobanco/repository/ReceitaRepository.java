package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Receita;

@Repository
public class ReceitaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertReceita(Receita receita) {
        jdbcTemplate.update("INSERT INTO RECEITA (DATA_HORA_CONSULTA, CRM, MATRICULA_MEDICO, CODIGO_PACIENTE, NOME_REMEDIO, DOSAGEM, QUANTIDADE, UNIDADE_MEDIDA, HORARIO, RECEITA_CONTROLADA, STATUS_RECEITA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            receita.getDataHoraConsulta(), receita.getCrm(), receita.getMatriculaFuncionarioMedico(), receita.getCodigoPaciente(), receita.getNomeRemedio(),
            receita.getDosagem(), receita.getQuantidade(), receita.getUnidadeMedida(), receita.getHorario(), receita.getReceitacontrolada(), receita.getStatusReceita());
    }
    
    public boolean deleteReceita(int id_receita) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM RECEITA WHERE ID_RECEITA = ?", id_receita);
    
        if (rowsAffected > 0) {
            System.out.println("Receita e suas dependências foram excluídas com sucesso.");
        } else {
            System.out.println("Não foi possível excluir a Receita ou não foi encontrada na base de dados.");
        }
        
        return rowsAffected > 0;
    }

    public List<Receita> getAllReceitas() {
        return jdbcTemplate.query("SELECT * FROM RECEITA", (resultSet, rowNum) -> {
            Receita receita = new Receita(rowNum, null, null, rowNum, rowNum, null, null, rowNum, null, null, null, false, null, null);
            receita.setIdReceita(resultSet.getInt("ID_RECEITA"));
            receita.setDataHoraConsulta(resultSet.getTimestamp("DATA_HORA_CONSULTA"));
            receita.setCrm(resultSet.getString("CRM"));
            receita.setMatriculaFuncionarioMedico(resultSet.getInt("MATRICULA_MEDICO"));
            receita.setCodigoPaciente(resultSet.getInt("CODIGO_PACIENTE"));
            receita.setNomeRemedio(resultSet.getString("NOME_REMEDIO"));
            receita.setDosagem(resultSet.getString("DOSAGEM"));
            receita.setQuantidade(resultSet.getInt("QUANTIDADE"));
            receita.setUnidadeMedida(resultSet.getString("UNIDADE_MEDIDA"));
            receita.setHorario(resultSet.getString("HORARIO"));
            receita.setReceitaControlada(resultSet.getBoolean("RECEITA_CONTROLADA"));
            receita.setStatusReceita(resultSet.getString("STATUS_RECEITA"));
            return receita;
        });
    }

    public boolean updateReceita(Receita receita) {
        int rowsAffected = jdbcTemplate.update("UPDATE RECEITA SET DATA_HORA_CONSULTA = ?, CRM = ?, MATRICULA_MEDICO = ?, CODIGO_PACIENTE = ?, NOME_REMEDIO = ?, DOSAGEM = ?, QUANTIDADE = ?, UNIDADE_MEDIDA = ?, HORARIO = ?, RECEITA_CONTROLADA = ?, STATUS_RECEITA = ? WHERE ID_RECEITA = ?",
            receita.getDataHoraConsulta(), receita.getCrm(), receita.getMatriculaFuncionarioMedico(), receita.getCodigoPaciente(), receita.getNomeRemedio(),
            receita.getDosagem(), receita.getQuantidade(), receita.getUnidadeMedida(), receita.getHorario(), receita.getReceitacontrolada(), receita.getStatusReceita(), receita.getIdReceita());
        return rowsAffected > 0;
    }
}
