package br.com.petTADS.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Cirurgia{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate data_cirurgia;

    public Cirurgia (){}

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

    public LocalDate getData_cirurgia() {
        return data_cirurgia;
    }

    public void setData_cirurgia(LocalDate data_cirurgia) {
        this.data_cirurgia = data_cirurgia;
    }


}