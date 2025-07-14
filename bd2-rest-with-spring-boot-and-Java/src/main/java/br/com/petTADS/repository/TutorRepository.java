package br.com.petTADS.repository;
import br.com.petTADS.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
