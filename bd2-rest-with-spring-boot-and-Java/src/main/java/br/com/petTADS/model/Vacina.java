package br.com.petTADS.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Vacina{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate dataVacina;

    public Vacina(){}

    public Vacina(String nome, LocalDate dataVacina){
        this.nome = nome;
        this.dataVacina = dataVacina;
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

    public LocalDate getDataVacina() {
        return dataVacina;
    }

    public void setDataVacina(LocalDate dataVacina) {
        this.dataVacina = dataVacina;
    }
}