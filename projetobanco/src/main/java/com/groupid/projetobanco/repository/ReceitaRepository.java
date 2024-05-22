package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Receita;

@Repository
public class ReceitaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertReceita(Receita receita) {
      
        try {
            String sql = "INSERT INTO receita(data_prescricao, id_receita, crm, quantidade, horario, dosagem, status_receita, hora_consulta, matricula_medico, cpf_paciente, nome_remedio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, receita.getDataPrescricao(), receita.getIdReceita(), receita.getCrm(), receita.getQuantidade(),
                            receita.getHorario(), receita.getDosagem(), receita.getStatusReceita(), receita.getHoraConsulta(),
                            receita.getMatriculaFuncionarioMedico(), receita.getCpfPaciente(), receita.getNomeRemedio());
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao inserir receita: " + e.getMessage(), e);
        }
    }
    
    public boolean deleteReceita(int id_receita) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM Receita WHERE ID_RECEITA = ?", id_receita);
    
        if (rowsAffected > 0) {
            System.out.println("Receita e suas dependências foram excluídos com sucesso.");
        } else {
            System.out.println("Não foi possível excluir a Receita ou não encontrado na base de dados.");
        }
        
        return rowsAffected > 0;
    }

    public List<Receita> getAllReceitas(){
        return jdbcTemplate.query("SELECT * FROM RECEITA", (resultSet, rowNum) -> {
            Receita receita = new Receita(null, rowNum, null, null, null, null, null, null, rowNum, null, null);
            receita.setIdReceita(resultSet.getInt("ID_RECEITA"));
            receita.setDataPrescricao(resultSet.getDate("DATAPRESCRICAO"));
            receita.setCrm(resultSet.getString("CRM"));
            receita.setQuantidade(resultSet.getString("QUANTIDADE"));
            receita.setHorario(resultSet.getString("HORARIO"));
            receita.setDosagem(resultSet.getString("DOSAGEM"));
            receita.setStatusReceita(resultSet.getString("STATUSRECEITA"));
            receita.setHoraConsulta(resultSet.getTime("HORACONSULTA"));
            receita.setMatriculaFuncionarioMedico(resultSet.getInt("MATRICULAFUNCIONARIOMEDICO"));
            receita.setCpfPaciente(resultSet.getString("CPFPACIENTE"));
            receita.setNomeRemedio(resultSet.getString("NOMEREMEDIO"));
            return receita;
        });
    }
}
