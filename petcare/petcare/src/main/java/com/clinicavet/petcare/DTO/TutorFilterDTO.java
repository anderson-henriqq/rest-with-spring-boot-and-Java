package com.clinicavet.petcare.DTO;

// DTO para filtros de Tutor
public class TutorFilterDTO {
    
    private String nome;
    private String contato;
    private String tipoPet; // Filtrar tutores que têm pets de um tipo específico
    private Boolean comPets; // true = tem pets, false = não tem pets, null = todos
    
    // Construtores
    
    public TutorFilterDTO() {}
    
    public TutorFilterDTO(String nome, String contato) {
        this.nome = nome;
        this.contato = contato;
    }
    
    public TutorFilterDTO(String nome, String contato, String tipoPet, Boolean comPets) {
        this.nome = nome;
        this.contato = contato;
        this.tipoPet = tipoPet;
        this.comPets = comPets;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getContato() {
        return contato;
    }
    
    public void setContato(String contato) {
        this.contato = contato;
    }
    
    public String getTipoPet() {
        return tipoPet;
    }
    
    public void setTipoPet(String tipoPet) {
        this.tipoPet = tipoPet;
    }
    
    public Boolean getComPets() {
        return comPets;
    }
    
    public void setComPets(Boolean comPets) {
        this.comPets = comPets;
    }
    
    // Métodos utilitários
    
    // Verifica se há pelo menos um filtro definido
    public boolean hasFilters() {
        return (nome != null && !nome.trim().isEmpty()) ||
               (contato != null && !contato.trim().isEmpty()) ||
               (tipoPet != null && !tipoPet.trim().isEmpty()) ||
               comPets != null;
    }
    
    @Override
    public String toString() {
        return "TutorFilterDTO{" +
                "nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", tipoPet='" + tipoPet + '\'' +
                ", comPets=" + comPets +
                '}';
    }
}
