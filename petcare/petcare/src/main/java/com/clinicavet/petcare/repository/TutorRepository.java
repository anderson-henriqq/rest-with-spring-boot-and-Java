package com.clinicavet.petcare.repository;

import com.clinicavet.petcare.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    
   
    
    
    List<Tutor> findByNomeContainingIgnoreCase(String nome);
    
    
    List<Tutor> findByContatoContainingIgnoreCase(String contato);
    
    
    @Query("SELECT DISTINCT t FROM Tutor t WHERE SIZE(t.pets) > 0")
    List<Tutor> findTutoresComPets();
    
    
    @Query("SELECT t FROM Tutor t WHERE SIZE(t.pets) = 0")
    List<Tutor> findTutoresSemPets();
    
    
    @Query("SELECT DISTINCT t FROM Tutor t JOIN t.pets p WHERE LOWER(p.tipo) = LOWER(:tipo)")
    List<Tutor> findTutoresByTipoPet(@Param("tipo") String tipo);
    
    
    @Query("SELECT COUNT(p) FROM Pet p WHERE p.tutor.id = :tutorId")
    Long countPetsByTutorId(@Param("tutorId") Long tutorId);
}