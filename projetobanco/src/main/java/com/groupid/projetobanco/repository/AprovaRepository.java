package com.groupid.projetobanco.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.groupid.projetobanco.models.Aprova;

@Repository
public class AprovaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertAprova(Aprova aprova) {
        jdbcTemplate.update("INSERT INTO APROVA (MATRICULA_FARMACEUTICO, ID_RECEITA_CONTROLADA) VALUES(?, ?)",
            aprova.getMatriculaFuncionarioFarmaceuticoAprova(), aprova.getIdReceitaControlada());
    }

    public boolean deleteAprova(int matricula_farmaceutico, int id_receita_controlada) {
        int rowsAffected = jdbcTemplate.update("DELETE FROM APROVA WHERE MATRICULA_FARMACEUTICO = ? AND ID_RECEITA_CONTROLADA = ?", 
            matricula_farmaceutico, id_receita_controlada);
        return rowsAffected > 0;
    }

    public List<Aprova> getAllAprova() {
        return jdbcTemplate.query("SELECT * FROM APROVA", (resultSet, rowNum) -> {
            Aprova aprova = new Aprova(
                resultSet.getInt("MATRICULA_FARMACEUTICO"), 
                resultSet.getInt("ID_RECEITA_CONTROLADA")
            );
            return aprova;
        });
    }
}
