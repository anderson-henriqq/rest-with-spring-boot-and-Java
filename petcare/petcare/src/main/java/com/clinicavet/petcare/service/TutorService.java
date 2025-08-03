package com.clinicavet.petcare.service;

import com.clinicavet.petcare.DTO.TutorFilterDTO;
import com.clinicavet.petcare.model.Tutor;
import com.clinicavet.petcare.repository.TutorRepository;
import com.clinicavet.petcare.repository.specification.TutorSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public List<Tutor> listarTodos() {
        return tutorRepository.findAll();
    }

    public Optional<Tutor> buscarPorId(Long id) {
        return tutorRepository.findById(id);
    }

    public Tutor atualizar(Long id, Tutor tutor) {
        Tutor existente = tutorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));
        existente.setNome(tutor.getNome());
        existente.setContato(tutor.getContato());
        return tutorRepository.save(existente);
    }

    public void deletar(Long id) {
        tutorRepository.deleteById(id);
    }
   // Filtros usando Specification
    public List<Tutor> buscarPorNome(String nome) {
        return tutorRepository.findAll(TutorSpecification.comNome(nome));
    }

    public List<Tutor> buscarPorContato(String contato) {
        return tutorRepository.findAll(TutorSpecification.comContato(contato));
    }

    public List<Tutor> listarTutoresComPets() {
        return tutorRepository.findAll(TutorSpecification.comPets());
    }

    public List<Tutor> listarTutoresSemPets() {
        return tutorRepository.findAll(TutorSpecification.semPets());
    }

    public List<Tutor> buscarPorTipoPet(String tipo) {
        return tutorRepository.findAll(TutorSpecification.comPetsTipo(tipo));
    }

    public Long contarPetsPorTutor(Long tutorId) {
        // Buscar o tutor e contar seus pets
        Optional<Tutor> tutor = tutorRepository.findOne(TutorSpecification.comId(tutorId));
        return tutor.map(t -> (long) t.getPets().size()).orElse(0L);
    }

    public Optional<Tutor> buscarComPets(Long id) {
        Optional<Tutor> tutor = tutorRepository.findById(id);
        if (tutor.isPresent()) {
            tutor.get().getPets().size();
        }
        return tutor;
    }

    public List<Tutor> buscarComFiltros(TutorFilterDTO filtros) {
        if (!filtros.hasFilters()) {
            return listarTodos();
        }

        // Usar Specification para filtros mais dinâmicos
        Specification<Tutor> spec = null;

        if (filtros.getNome() != null && !filtros.getNome().trim().isEmpty()) {
            spec = TutorSpecification.comNome(filtros.getNome());
        }

        if (filtros.getContato() != null && !filtros.getContato().trim().isEmpty()) {
            Specification<Tutor> contatoSpec = TutorSpecification.comContato(filtros.getContato());
            spec = spec == null ? contatoSpec : spec.and(contatoSpec);
        }

        if (filtros.getTipoPet() != null && !filtros.getTipoPet().trim().isEmpty()) {
            Specification<Tutor> tipoSpec = TutorSpecification.comPetsTipo(filtros.getTipoPet());
            spec = spec == null ? tipoSpec : spec.and(tipoSpec);
        }

        if (filtros.getComPets() != null) {
            Specification<Tutor> petsSpec = filtros.getComPets() ? 
                TutorSpecification.comPets() : TutorSpecification.semPets();
            spec = spec == null ? petsSpec : spec.and(petsSpec);
        }

        return spec == null ? listarTodos() : tutorRepository.findAll(spec);
    }
    
    // Método usando Specification para busca avançada por nome de pet
    public List<Tutor> buscarPorNomePet(String nomePet) {
        return tutorRepository.findAll(TutorSpecification.comPetNome(nomePet));
    }
    
    // Método usando Specification para busca por raça de pet
    public List<Tutor> buscarPorRacaPet(String raca) {
        return tutorRepository.findAll(TutorSpecification.comPetsRaca(raca));
    }
    
    // Método usando Specification para busca por idade dos pets
    public List<Tutor> buscarPorIdadePets(Integer idadeMin, Integer idadeMax) {
        return tutorRepository.findAll(TutorSpecification.comPetsIdadeEntre(idadeMin, idadeMax));
    }
}
