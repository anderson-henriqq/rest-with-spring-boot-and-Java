package com.clinicavet.petcare.service;

import com.clinicavet.petcare.DTO.TutorFilterDTO;
import com.clinicavet.petcare.model.Tutor;
import com.clinicavet.petcare.repository.TutorRepository;
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
   // Filtros
    public List<Tutor> buscarPorNome(String nome) {
        return tutorRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Tutor> buscarPorContato(String contato) {
        return tutorRepository.findByContatoContainingIgnoreCase(contato);
    }

    public List<Tutor> listarTutoresComPets() {
        return tutorRepository.findTutoresComPets();
    }

    public List<Tutor> listarTutoresSemPets() {
        return tutorRepository.findTutoresSemPets();
    }

    public List<Tutor> buscarPorTipoPet(String tipo) {
        return tutorRepository.findTutoresByTipoPet(tipo);
    }

    public Long contarPetsPorTutor(Long tutorId) {
        return tutorRepository.countPetsByTutorId(tutorId);
    }

    public Optional<Tutor> buscarComPets(Long id) {
        Optional<Tutor> tutor = tutorRepository.findById(id);
        if (tutor.isPresent()) {
            tutor.get().getPets().size();
        }
        return tutor;
    }

    public List<Tutor> buscarComFiltros(TutorFilterDTO filtros) {
        if (filtros.isEmpty()) {
            return listarTodos();
        }

        List<Tutor> tutores = null;

        if (filtros.getNome() != null && !filtros.getNome().trim().isEmpty()) {
            tutores = buscarPorNome(filtros.getNome());
        }

        if (tutores == null && filtros.getContato() != null && !filtros.getContato().trim().isEmpty()) {
            tutores = buscarPorContato(filtros.getContato());
        }

        if (tutores == null && filtros.getTipoPet() != null && !filtros.getTipoPet().trim().isEmpty()) {
            tutores = buscarPorTipoPet(filtros.getTipoPet());
        }

        if (tutores == null && filtros.getComPets() != null) {
            if (filtros.getComPets()) {
                tutores = listarTutoresComPets();
            } else {
                tutores = listarTutoresSemPets();
            }
        }

        if (tutores == null) {
            tutores = listarTodos();
        }

        return tutores;
    }
}
