package com.example.Tache.Controller;


import com.example.Tache.Service.TacheService;
import com.example.Tache.model.Tache;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/taches")
@RequiredArgsConstructor
public class TacheController {

    private final TacheService tacheService;

    @PostMapping("/add")
    public ResponseEntity<Tache> createTache(@RequestBody Tache tache) {
        return new ResponseEntity<>(tacheService.createTache(tache), HttpStatus.CREATED);
    }

    @GetMapping("/with-projets/{tache-id}")
    public ResponseEntity<FullTacheResponse> getAllTaches(
            @PathVariable("tache-id") Integer tacheId) {
        return  ResponseEntity.ok(tacheService.getAllTachesWithProjet(tacheId));
    }
}