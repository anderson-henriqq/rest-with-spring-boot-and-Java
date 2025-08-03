package com.clinicavet.petcare.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String contato;
    
    // Relacionamento com Pet
    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets = new ArrayList<>();

    public Tutor() {}

    public Tutor(String nome, String contato){
        this.nome = nome;
        this.contato = contato;
    }

    public Long getId(){ 
        return id;
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getContato(){
        return contato;
    }

    public void setContato(String contato){
        this.contato = contato;
    }
    
    public List<Pet> getPets() {
        return pets;
    }
    
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
    
    // Métodos auxiliares para gerenciar pets
    public void adicionarPet(Pet pet) {
        pets.add(pet);
        pet.setTutor(this);
    }
    
    public void removerPet(Pet pet) {
        pets.remove(pet);
        pet.setTutor(null);
    }
}

