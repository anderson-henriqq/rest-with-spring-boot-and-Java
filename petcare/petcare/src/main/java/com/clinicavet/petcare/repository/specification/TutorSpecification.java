package com.clinicavet.petcare.repository.specification;

import com.clinicavet.petcare.model.Tutor;
import com.clinicavet.petcare.model.Pet;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;

public class TutorSpecification {

    // Filtro por nome do tutor
    public static Specification<Tutor> comNome(String nome) {
        return (root, query, criteriaBuilder) -> {
            if (nome == null || nome.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + nome.toLowerCase() + "%");
        };
    }

    // Filtro por contato do tutor
    public static Specification<Tutor> comContato(String contato) {
        return (root, query, criteriaBuilder) -> {
            if (contato == null || contato.isEmpty()) {
                return null;
            }
            return criteriaBuilder.like(criteriaBuilder.lower(root.get("contato")), "%" + contato.toLowerCase() + "%");
        };
    }

    // Filtro para tutores que têm pets
    public static Specification<Tutor> comPets() {
        return (root, query, criteriaBuilder) -> {
            Join<Tutor, Pet> petJoin = root.join("pets", JoinType.INNER);
            return criteriaBuilder.isNotNull(petJoin.get("id"));
        };
    }

    // Filtro para tutores que não têm pets
    public static Specification<Tutor> semPets() {
        return (root, query, criteriaBuilder) -> {
            Join<Tutor, Pet> petJoin = root.join("pets", JoinType.LEFT);
            return criteriaBuilder.isNull(petJoin.get("id"));
        };
    }

    // Filtro para tutores que têm pets de um tipo específico
    public static Specification<Tutor> comPetsTipo(String tipoPet) {
        return (root, query, criteriaBuilder) -> {
            if (tipoPet == null || tipoPet.isEmpty()) {
                return null;
            }
            Join<Tutor, Pet> petJoin = root.join("pets", JoinType.INNER);
            return criteriaBuilder.like(criteriaBuilder.lower(petJoin.get("tipo")), "%" + tipoPet.toLowerCase() + "%");
        };
    }

    // Filtro para tutores que têm pets de uma raça específica
    public static Specification<Tutor> comPetsRaca(String raca) {
        return (root, query, criteriaBuilder) -> {
            if (raca == null || raca.isEmpty()) {
                return null;
            }
            Join<Tutor, Pet> petJoin = root.join("pets", JoinType.INNER);
            return criteriaBuilder.like(criteriaBuilder.lower(petJoin.get("raca")), "%" + raca.toLowerCase() + "%");
        };
    }

    // Filtro para tutores que têm pets com idade específica
    public static Specification<Tutor> comPetsIdadeEntre(Integer idadeMin, Integer idadeMax) {
        return (root, query, criteriaBuilder) -> {
            if (idadeMin == null && idadeMax == null) {
                return null;
            }
            
            Join<Tutor, Pet> petJoin = root.join("pets", JoinType.INNER);
            
            if (idadeMin != null && idadeMax != null) {
                return criteriaBuilder.between(petJoin.get("idade"), idadeMin, idadeMax);
            } else if (idadeMin != null) {
                return criteriaBuilder.greaterThanOrEqualTo(petJoin.get("idade"), idadeMin);
            } else {
                return criteriaBuilder.lessThanOrEqualTo(petJoin.get("idade"), idadeMax);
            }
        };
    }

    // Filtro para tutores que têm pets com nome específico
    public static Specification<Tutor> comPetNome(String nomePet) {
        return (root, query, criteriaBuilder) -> {
            if (nomePet == null || nomePet.isEmpty()) {
                return null;
            }
            Join<Tutor, Pet> petJoin = root.join("pets", JoinType.INNER);
            return criteriaBuilder.like(criteriaBuilder.lower(petJoin.get("nome")), "%" + nomePet.toLowerCase() + "%");
        };
    }

    // Filtro para tutor específico (usado para contar pets)
    public static Specification<Tutor> comId(Long tutorId) {
        return (root, query, criteriaBuilder) -> {
            if (tutorId == null) {
                return null;
            }
            return criteriaBuilder.equal(root.get("id"), tutorId);
        };
    }
}
