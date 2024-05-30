package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.groupid.projetobanco.models.Receita;

@Repository
public class ReceitaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertReceita(Receita receita) {
        jdbcTemplate.update("INSERT INTO RECEITA (DATA_HORA_CONSULTA, CRM, MATRICULA_MEDICO, CODIGO_PACIENTE, NOME_REMEDIO, DOSAGEM, QUANTIDADE, UNIDADE_MEDIDA, HORARIO, RECEITA_CONTROLADA, STATUS_RECEITA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
            receita.getDataHoraConsulta(), receita.getCrm(), receita.getMatriculaMedico(), receita.getCodigoPaciente(), receita.getNomeRemedio(),
            receita.getDosagem(), receita.getQuantidade(), receita.getUnidadeMedida(), receita.getHorario(), receita.getReceitaControlada(), 
            receita.getStatusReceita());

        return true;
    }
    
    @Transactional
    public boolean deleteReceita(int id_receita) {
        jdbcTemplate.update("DELETE FROM APROVA WHERE ID_RECEITA_CONTROLADA = ?", id_receita);
        jdbcTemplate.update("DELETE FROM RECEITA_CONTROLE_ESPECIAL WHERE ID_RECEITA = ?", id_receita);
        jdbcTemplate.update("DELETE FROM RECEBE WHERE ID_RECEITA = ?", id_receita);
        jdbcTemplate.update("DELETE FROM CONTEM WHERE ID_RECEITA = ?", id_receita);

        int rowsAffectedReceita = jdbcTemplate.update("DELETE FROM RECEITA WHERE ID_RECEITA = ?", id_receita);

        if (rowsAffectedReceita > 0) {
            System.out.println("Receita e suas dependências foram excluídas com sucesso.");
        } else {
            System.out.println("Não foi possível excluir a Receita ou não foi encontrada na base de dados.");
        }

        return rowsAffectedReceita > 0;
    }

    public List<Receita> getAllReceitas() {
        return jdbcTemplate.query("SELECT * FROM RECEITA", (resultSet, rowNum) -> {
            Receita receita = new Receita(null, null, rowNum, rowNum, null, null, rowNum, null, null, false, null);
            receita.setIdReceita(resultSet.getInt("ID_RECEITA"));
            receita.setDataHoraConsulta(resultSet.getTimestamp("DATA_HORA_CONSULTA"));
            receita.setCrm(resultSet.getString("CRM"));
            receita.setMatriculaMedico(resultSet.getInt("MATRICULA_MEDICO"));
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
        int rowsAffected = jdbcTemplate.update("UPDATE RECEITA SET DATA_HORA_CONSULTA = ?, CRM = ?, MATRICULA_MEDICO = ?, CODIGO_PACIENTE = ?, NOME_REMEDIO = ?, DOSAGEM = ?, QUANTIDADE = ?, UNIDADE_MEDIDA = ?, HORARIO = ?, RECEITA_CONTROLADA = ?, STATUS_RECEITA = ?, TEMPO_DE_ESPERA = ? WHERE ID_RECEITA = ?",
            receita.getDataHoraConsulta(), receita.getCrm(), receita.getMatriculaMedico(), receita.getCodigoPaciente(), receita.getNomeRemedio(),
            receita.getDosagem(), receita.getQuantidade(), receita.getUnidadeMedida(), receita.getHorario(), receita.getReceitaControlada(), receita.getStatusReceita(), receita.getIdReceita(), receita.getTempoDeEspera());
        return rowsAffected > 0;
    }
}
