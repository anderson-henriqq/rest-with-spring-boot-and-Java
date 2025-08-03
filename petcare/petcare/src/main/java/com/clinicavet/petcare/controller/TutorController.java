package com.clinicavet.petcare.controller;

import com.clinicavet.petcare.DTO.TutorFilterDTO;
import com.clinicavet.petcare.model.Tutor;
import com.clinicavet.petcare.service.TutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
@CrossOrigin(origins = "*")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping
    public ResponseEntity<Tutor> salvar(@RequestBody Tutor tutor) {
        return ResponseEntity.ok(tutorService.salvar(tutor));
    }

    @GetMapping
    public ResponseEntity<List<Tutor>> listarTodos() {
        return ResponseEntity.ok(tutorService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> buscarPorId(@PathVariable Long id) {
        return tutorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutor> atualizar(@PathVariable Long id, @RequestBody Tutor tutor) {
        return ResponseEntity.ok(tutorService.atualizar(id, tutor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tutorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    
    // Filtros simples
    
    // GET /api/tutores/nome/João
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Tutor>> buscarPorNome(@PathVariable String nome) {
        List<Tutor> tutores = tutorService.buscarPorNome(nome);
        return ResponseEntity.ok(tutores);
    }
    
    // GET /api/tutores/contato/11999
    @GetMapping("/contato/{contato}")
    public ResponseEntity<List<Tutor>> buscarPorContato(@PathVariable String contato) {
        List<Tutor> tutores = tutorService.buscarPorContato(contato);
        return ResponseEntity.ok(tutores);
    }
    
    // GET /api/tutores/com-pets
    @GetMapping("/com-pets")
    public ResponseEntity<List<Tutor>> listarTutoresComPets() {
        List<Tutor> tutores = tutorService.listarTutoresComPets();
        return ResponseEntity.ok(tutores);
    }
    
    // GET /api/tutores/sem-pets
    @GetMapping("/sem-pets")
    public ResponseEntity<List<Tutor>> listarTutoresSemPets() {
        List<Tutor> tutores = tutorService.listarTutoresSemPets();
        return ResponseEntity.ok(tutores);
    }
    
    // GET /api/tutores/tipo-pet/Cachorro
    @GetMapping("/tipo-pet/{tipo}")
    public ResponseEntity<List<Tutor>> buscarPorTipoPet(@PathVariable String tipo) {
        List<Tutor> tutores = tutorService.buscarPorTipoPet(tipo);
        return ResponseEntity.ok(tutores);
    }
    
    // GET /api/tutores/1/com-pets - busca tutor com lista de pets
    @GetMapping("/{id}/com-pets")
    public ResponseEntity<Tutor> buscarComPets(@PathVariable Long id) {
        return tutorService.buscarComPets(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // GET /api/tutores/1/contar-pets - conta quantos pets o tutor tem
    @GetMapping("/{id}/contar-pets")
    public ResponseEntity<Long> contarPets(@PathVariable Long id) {
        Long quantidade = tutorService.contarPetsPorTutor(id);
        return ResponseEntity.ok(quantidade);
    }
    
    // GET /api/tutores/buscar?nome=João&tipo=Cachorro
    @GetMapping("/buscar")
    public ResponseEntity<List<Tutor>> buscarComFiltros(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String tipo) {
        
        List<Tutor> tutores;
        
        if (nome != null && tipo != null) {
            // Buscar por nome e depois filtrar por tipo de pet
            tutores = tutorService.buscarPorNome(nome);
            // Aqui poderia implementar um filtro mais complexo
        } else if (nome != null) {
            tutores = tutorService.buscarPorNome(nome);
        } else if (tipo != null) {
            tutores = tutorService.buscarPorTipoPet(tipo);
        } else {
            tutores = tutorService.listarTodos();
        }
        
        return ResponseEntity.ok(tutores);
    }
    
    
    // GET /api/tutores/filtro?nome=João&tipoPet=Cachorro&comPets=true
    @GetMapping("/filtro")
    public ResponseEntity<List<Tutor>> buscarComFiltroDTO(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String contato,
            @RequestParam(required = false) String tipoPet,
            @RequestParam(required = false) Boolean comPets) {
        
        TutorFilterDTO filtros = new TutorFilterDTO();
        filtros.setNome(nome);
        filtros.setContato(contato);
        filtros.setTipoPet(tipoPet);
        filtros.setComPets(comPets);
        
        List<Tutor> tutores = tutorService.buscarComFiltros(filtros);
        return ResponseEntity.ok(tutores);
    }
    
    // Endpoints usando Specification para consultas avançadas
    
    // GET /api/tutores/pet-nome/Rex - tutores que têm pet com nome específico
    @GetMapping("/pet-nome/{nomePet}")
    public ResponseEntity<List<Tutor>> buscarPorNomePet(@PathVariable String nomePet) {
        List<Tutor> tutores = tutorService.buscarPorNomePet(nomePet);
        return ResponseEntity.ok(tutores);
    }
    
    // GET /api/tutores/pet-raca/Labrador - tutores que têm pet de raça específica
    @GetMapping("/pet-raca/{raca}")
    public ResponseEntity<List<Tutor>> buscarPorRacaPet(@PathVariable String raca) {
        List<Tutor> tutores = tutorService.buscarPorRacaPet(raca);
        return ResponseEntity.ok(tutores);
    }
    
    // GET /api/tutores/pet-idade?min=2&max=5 - tutores com pets entre idades
    @GetMapping("/pet-idade")
    public ResponseEntity<List<Tutor>> buscarPorIdadePets(
            @RequestParam(required = false) Integer min,
            @RequestParam(required = false) Integer max) {
        List<Tutor> tutores = tutorService.buscarPorIdadePets(min, max);
        return ResponseEntity.ok(tutores);
    }
}