package com.groupid.projetobanco.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.groupid.projetobanco.models.Setor_hospitalar;

@Repository
public class SetorHospitalarRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertSetorHospitalar(Setor_hospitalar setorHospitalar) {
        String sql = "INSERT INTO SETOR_HOSPITALAR (NOME_DO_SETOR, QUANTIDADE_RECEITAS) VALUES (?, ?)";
        jdbcTemplate.update(sql, setorHospitalar.getNomeDoSetor(), setorHospitalar.getQuantidadeReceitas());
        setorHospitalar.setCodigoSetor(setorHospitalar.getCodigoSetor());
        return true;
    }

    public boolean deleteSetorHospitalar(int codigo_setor) {
        jdbcTemplate.update("DELETE FROM TELEFONE WHERE COD_PACIENTE IN (SELECT CODIGO_PACIENTE FROM PACIENTE WHERE CODIGO_SETOR = ?)", codigo_setor);
        jdbcTemplate.update("DELETE FROM RECEBE WHERE ID_RECEITA IN (SELECT ID_RECEITA FROM RECEITA WHERE (DATA_HORA_CONSULTA, CODIGO_PACIENTE, MATRICULA_MEDICO) IN (SELECT DATA_HORA, CODIGO_PACIENTE, MATRICULA_MEDICO FROM CONSULTA WHERE CODIGO_PACIENTE IN (SELECT CODIGO_PACIENTE FROM PACIENTE WHERE CODIGO_SETOR = ?)))", codigo_setor);
        jdbcTemplate.update("DELETE FROM CONTEM WHERE ID_RECEITA IN (SELECT ID_RECEITA FROM RECEITA WHERE (DATA_HORA_CONSULTA, CODIGO_PACIENTE, MATRICULA_MEDICO) IN (SELECT DATA_HORA, CODIGO_PACIENTE, MATRICULA_MEDICO FROM CONSULTA WHERE CODIGO_PACIENTE IN (SELECT CODIGO_PACIENTE FROM PACIENTE WHERE CODIGO_SETOR = ?)))", codigo_setor);
    
        jdbcTemplate.update("DELETE FROM RECEITA WHERE (DATA_HORA_CONSULTA, CODIGO_PACIENTE, MATRICULA_MEDICO) IN (SELECT DATA_HORA, CODIGO_PACIENTE, MATRICULA_MEDICO FROM CONSULTA WHERE CODIGO_PACIENTE IN (SELECT CODIGO_PACIENTE FROM PACIENTE WHERE CODIGO_SETOR = ?))", codigo_setor);
    
        jdbcTemplate.update("DELETE FROM CONSULTA WHERE CODIGO_PACIENTE IN (SELECT CODIGO_PACIENTE FROM PACIENTE WHERE CODIGO_SETOR = ?)", codigo_setor);
    
        jdbcTemplate.update("DELETE FROM PACIENTE WHERE CODIGO_SETOR = ?", codigo_setor);
    
        int rowsAffected = jdbcTemplate.update("DELETE FROM SETOR_HOSPITALAR WHERE CODIGO_SETOR = ?", codigo_setor);
    
        if (rowsAffected > 0) {
            System.out.println("Setor Hospitalar e suas dependências foram excluídos com sucesso.");
        } else {
            System.out.println("Não foi possível excluir o Setor Hospitalar ou não foi encontrado na base de dados.");
        }
    
        return rowsAffected > 0;
    }    

    public List<Setor_hospitalar> getAllSetoresHospitalar() {
        return jdbcTemplate.query("SELECT * FROM SETOR_HOSPITALAR", (resultSet, rowNum) -> {
            Setor_hospitalar setorHospitalar = new Setor_hospitalar(null, rowNum);
            setorHospitalar.setCodigoSetor(resultSet.getInt("CODIGO_SETOR"));
            setorHospitalar.setNomeDoSetor(resultSet.getString("NOME_DO_SETOR"));
            setorHospitalar.setQuantidadeReceitas(resultSet.getInt("QUANTIDADE_RECEITAS"));
            return setorHospitalar;
        });
    }

    public boolean updateSetorHospitalar(Setor_hospitalar setorHospitalar) {
        int rowsAffected = jdbcTemplate.update(
            "UPDATE SETOR_HOSPITALAR SET NOME_DO_SETOR = ? WHERE CODIGO_SETOR = ?",
            setorHospitalar.getNomeDoSetor(), setorHospitalar.getCodigoSetor()
        );
        return rowsAffected > 0;
    }
}
