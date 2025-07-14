package br.com.petTADS.repository;
import br.com.petTADS.model.Cirurgia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CirurgiaRepository extends JpaRepository<Cirurgia, Long> {
}
