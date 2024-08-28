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
        return new ResponseEntity<>(projetService.createProjet(projet), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Projet>> getAllProjets() {
        return new ResponseEntity<>(projetService.getAllProjets(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable int id, @RequestBody Projet projet) { // Change Long to int
        Projet updatedProjet = projetService.updateProjet(id, projet); // Change Long to int
        return new ResponseEntity<>(updatedProjet, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable int id) {
        projetService.deleteProjet(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
