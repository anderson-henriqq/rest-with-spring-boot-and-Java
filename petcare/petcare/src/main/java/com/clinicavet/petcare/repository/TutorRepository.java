package com.clinicavet.petcare.repository;

import com.clinicavet.petcare.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TutorRepository extends JpaRepository<Tutor, Long>, JpaSpecificationExecutor<Tutor> {
    // Repository limpo - todas as consultas complexas via Specification
}