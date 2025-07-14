package br.com.petTADS.repository;
import br.com.petTADS.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}
