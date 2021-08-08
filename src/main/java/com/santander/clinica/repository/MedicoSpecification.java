package com.santander.clinica.repository;

import com.santander.clinica.model.Medico;
import com.santander.clinica.model.Medico_;
import org.springframework.data.jpa.domain.Specification;

public class MedicoSpecification {

  //  Buscar consulta por medico nome ou paciente nome ou especialidade
    public static Specification<Medico> nomes(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get(Medico_.NOME), "%"+nome+"%");
    }

    public static Specification<Medico> especialidades(String especialidade) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get(Medico_.especialidade), "%"+especialidade+"%");
    }

}
