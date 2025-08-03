package com.clinicavet.petcare.repository.specification;

import com.clinicavet.petcare.model.Atendimento;
import com.clinicavet.petcare.model.Pet;
import com.clinicavet.petcare.model.Veterinario;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;
import java.time.LocalDate;

public class AtendimentoSpecification {

    public static Specification<Atendimento> comDataMaiorOuIgualA(LocalDate dataInicio) {
        return (root, query, criteriaBuilder) ->
                dataInicio == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("data"), dataInicio);
    }

    public static Specification<Atendimento> comDataMenorOuIgualA(LocalDate dataFim) {
        return (root, query, criteriaBuilder) ->
                dataFim == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("data"), dataFim);
    }

    public static Specification<Atendimento> comPetNome(String petNome) {
        return (root, query, criteriaBuilder) -> {
            if (petNome == null || petNome.isEmpty()) {
                return null;
            }
            Join<Atendimento, Pet> petJoin = root.join("pet");
            return criteriaBuilder.like(criteriaBuilder.lower(petJoin.get("nome")), "%" + petNome.toLowerCase() + "%");
        };
    }

    public static Specification<Atendimento> comVeterinarioNome(String vetNome) {
        return (root, query, criteriaBuilder) -> {
            if (vetNome == null || vetNome.isEmpty()) {
                return null;
            }
            Join<Atendimento, Veterinario> vetJoin = root.join("veterinario");
            return criteriaBuilder.like(criteriaBuilder.lower(vetJoin.get("nome")), "%" + vetNome.toLowerCase() + "%");
        };
    }
}