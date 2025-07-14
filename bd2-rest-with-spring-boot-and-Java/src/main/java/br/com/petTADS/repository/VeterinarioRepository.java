package br.com.petTADS.repository;
import br.com.petTADS.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
