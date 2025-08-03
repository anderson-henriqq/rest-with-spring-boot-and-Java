package com.clinicavet.petcare.DTO;
import java.time.LocalDate;

public class AtendimentoDTO {

    private Long idAtendimento;
    private LocalDate data;
    private String descricao;
    private String nomePet;
    private String nomeVeterinario;

    public AtendimentoDTO(Long idAtendimento, LocalDate data, String descricao, String nomePet, String nomeVeterinario) {
        this.idAtendimento = idAtendimento;
        this.data = data;
        this.descricao = descricao;
        this.nomePet = nomePet;
        this.nomeVeterinario = nomeVeterinario;
    }

    public Long getIdAtendimento() { return idAtendimento; }
    public void setIdAtendimento(Long idAtendimento) { this.idAtendimento = idAtendimento; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public String getNomePet() { return nomePet; }
    public void setNomePet(String nomePet) { this.nomePet = nomePet; }
    public String getNomeVeterinario() { return nomeVeterinario; }
    public void setNomeVeterinario(String nomeVeterinario) { this.nomeVeterinario = nomeVeterinario; }
}
