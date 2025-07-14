package br.com.petTADS.repository;
import br.com.petTADS.model.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
