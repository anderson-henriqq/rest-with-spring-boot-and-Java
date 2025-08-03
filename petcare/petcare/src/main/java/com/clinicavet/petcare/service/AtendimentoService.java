package com.clinicavet.petcare.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.clinicavet.petcare.DTO.AtendimentoDTO;
import com.clinicavet.petcare.repository.specification.AtendimentoSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.clinicavet.petcare.model.Atendimento;
import com.clinicavet.petcare.repository.AtendimentoRepository;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public List<AtendimentoDTO> buscarComFiltros(LocalDate dataInicio, LocalDate dataFim, String petNome, String vetNome) {
        Specification<Atendimento> spec = AtendimentoSpecification.comDataMaiorOuIgualA(dataInicio)
            .and(AtendimentoSpecification.comDataMenorOuIgualA(dataFim))
            .and(AtendimentoSpecification.comPetNome(petNome))
            .and(AtendimentoSpecification.comVeterinarioNome(vetNome));

        List<Atendimento> atendimentos = atendimentoRepository.findAll(spec);

        return atendimentos.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    private AtendimentoDTO converterParaDTO(Atendimento atendimento) {
        return new AtendimentoDTO(
            atendimento.getId(),
            atendimento.getData(),
            atendimento.getDescricao(),
            atendimento.getPet() != null ? atendimento.getPet().getNome() : "Pet não informado",
            atendimento.getVeterinario() != null ? atendimento.getVeterinario().getNome() : "Veterinário não informado"
        );
    }

    public Atendimento salvar(Atendimento atendimento) {
        return atendimentoRepository.save(atendimento);
    }

    public List<Atendimento> listarTodos() {
        return atendimentoRepository.findAll();
    }

    public Optional<Atendimento> buscarPorId(Long id) {
        return atendimentoRepository.findById(id);
    }

    public void deletar(Long id) {
        atendimentoRepository.deleteById(id);
    }

    public Atendimento atualizar(Long id, Atendimento dadosAtualizados) {
        return atendimentoRepository.findById(id).map(atendimento -> {
            atendimento.setData(dadosAtualizados.getData());
            atendimento.setDescricao(dadosAtualizados.getDescricao());
            atendimento.setVeterinario(dadosAtualizados.getVeterinario());
            atendimento.setPet(dadosAtualizados.getPet());
            return atendimentoRepository.save(atendimento);
        }).orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
    }
}
