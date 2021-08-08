package com.santander.clinica.repository;

import com.santander.clinica.model.Agenda;
import com.santander.clinica.model.Agenda_;
import com.santander.clinica.model.Medico;
import com.santander.clinica.model.Medico_;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class AgendaSpecification {

    public static Specification<Agenda> medicos(Integer medico_id) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Agenda_.MEDICO), medico_id);
    }

    public static Specification<Agenda> dataHoraLivre(LocalDate dataLivre) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Agenda_.DATA), dataLivre);
    }

    public static Specification<Agenda> situacaoHorario() {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get(Agenda_.situacao), "L");
    }
}
