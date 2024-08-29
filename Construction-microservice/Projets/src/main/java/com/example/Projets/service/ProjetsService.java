package com.example.Projets.service;

import com.example.Projets.model.FullProjetResponse;
import com.example.Projets.model.Projets;

import java.util.List;

public interface ProjetsService {
    Projets ajouterProjet(Projets projet);
    Projets modifierProjet(Long id, Projets projet);
    List<Projets> allProjets();
    void supprimerProjet(Long id);
    FullProjetResponse projetWithTaches(Long id);
}
