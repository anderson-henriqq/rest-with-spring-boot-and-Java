package br.com.petTADS.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Atendimento{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataAtendimento;

    public Atendimento(){}

    public Atendimento(String nome, LocalDate dataAtendimento){
        this.nome = nome;
        this.dataAtendimento = dataAtendimento;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDate dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
}
