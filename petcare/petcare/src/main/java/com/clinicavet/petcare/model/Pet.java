package com.clinicavet.petcare.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;
    private String tipo;
    private String raca;
    
    // Relacionamento com Tutor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_id")
    @JsonBackReference
    private Tutor tutor;

    // Construtores
    public Pet() {}

    public Pet(String nome, Integer idade, String tipo, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.raca = raca;
    }
    
    public Pet(String nome, Integer idade, String tipo, String raca, Tutor tutor) {
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.raca = raca;
        this.tutor = tutor;
    }

    // Getters e Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Integer getIdade() { return idade; }

    public void setIdade(Integer idade) { this.idade = idade; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getRaca() { return raca; }

    public void setRaca(String raca) { this.raca = raca; }
    
    public Tutor getTutor() { return tutor; }
    
    public void setTutor(Tutor tutor) { this.tutor = tutor; }
}
