package com.example.Taches.service;

import com.example.Taches.model.Taches;
import com.example.Taches.model.FullTachesResponse;

import java.util.List;

public interface TachesService {
    Taches ajouterTache(Taches taches);
    Taches editTache(Long id, Taches taches);
    List<Taches> getAll();
    void deleteTaches(Long id);
    Taches changerStatut(Long id, Taches taches);

    void deleteByProjetId(Long projetId);

    List<Taches> getAllTachesByProjet(Long id);


}
