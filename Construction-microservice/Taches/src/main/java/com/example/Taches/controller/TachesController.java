package com.example.Taches.controller;

import com.example.Taches.model.FullTachesResponse;
import com.example.Taches.model.Taches;
import com.example.Taches.service.TachesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taches")
@RequiredArgsConstructor
public class TachesController {

    @Autowired
    TachesService tachesService;

    @PostMapping("/add")
    public Taches addTache(@RequestBody Taches taches){
        return tachesService.ajouterTache(taches);
    }

    @GetMapping("/all")
    public List<Taches> getAll(){
        return tachesService.getAll();
    }


    @GetMapping("/projet/{id}")
    public List<Taches> tachesOfProjet(@PathVariable Long id){
        return tachesService.getAllTachesByProjet(id);
    }

    @PutMapping("/edit/{id}")
    public Taches editTache(@PathVariable Long id, @RequestBody Taches taches){
        return tachesService.editTache(id, taches);
    }

    @PutMapping("/statut/{id}")
    public Taches changeStatut(@PathVariable Long id, @RequestBody Taches taches){
        return tachesService.changerStatut(id, taches);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        tachesService.deleteTaches(id);
    }

    @DeleteMapping("/projet/{id}")
    public void deleteTachesOfProjet(@PathVariable Long id){
        tachesService.deleteByProjetId(id);
    }
}
