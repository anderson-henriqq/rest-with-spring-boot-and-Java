package br.com.petTADS.model;

import jakarta.persistence.*;

@Entity
public class Medicamento{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dosagem;


    public Medicamento (){}


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


    public String getDosagem() {
        return dosagem;
    }


    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

}