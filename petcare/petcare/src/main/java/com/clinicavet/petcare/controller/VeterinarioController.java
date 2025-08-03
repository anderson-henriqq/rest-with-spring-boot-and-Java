package com.clinicavet.petcare.controller;

import com.clinicavet.petcare.model.Veterinario;
import com.clinicavet.petcare.service.VeterinarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
@CrossOrigin(origins = "*")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @PostMapping
    public ResponseEntity<Veterinario> salvar(@RequestBody Veterinario veterinario) {
        return ResponseEntity.ok(veterinarioService.salvar(veterinario));
    }

    @GetMapping
    public ResponseEntity<List<Veterinario>> listarTodos(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String especialidade) {
        
        // Se nenhum filtro for passado, ele lista todos.
        // Se filtros forem passados, ele usa o novo método do service.
        return ResponseEntity.ok(veterinarioService.buscarComFiltros(nome, especialidade));
        }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> buscarPorId(@PathVariable Long id) {
        return veterinarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veterinario> atualizar(@PathVariable Long id, @RequestBody Veterinario veterinario) {
        return ResponseEntity.ok(veterinarioService.atualizar(id, veterinario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veterinarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}