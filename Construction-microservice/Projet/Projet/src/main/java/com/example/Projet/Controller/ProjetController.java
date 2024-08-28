package com.example.Projet.Controller;

import com.example.Projet.Service.ProjetService;
import com.example.Projet.model.Projet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projets")
@RequiredArgsConstructor
public class ProjetController {

    private final ProjetService projetService;

    @PostMapping("/add")
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        Projet savedProjet = projetService.saveProjet(projet);
        return new ResponseEntity<>(savedProjet, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjets() {
        return new ResponseEntity<>(projetService.findAllProjets(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projet) {
        Projet updatedProjet = projetService.updateProjet(id, projet);
        return new ResponseEntity<>(updatedProjet, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjet(@PathVariable int id) {
        projetService.deleteProjet(id);
        return new ResponseEntity<>("Projet supprimé avec succès", HttpStatus.OK);
    }



}



