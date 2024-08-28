package com.example.Projet.Service;

import com.example.Projet.model.Projet;

import java.util.List;

public interface ProjetService {
    Projet createProjet(Projet projet);
    List<Projet> getAllProjets();
    Projet updateProjet(int id, Projet projet); // Change Long to int
    void deleteProjet(int id);
}
