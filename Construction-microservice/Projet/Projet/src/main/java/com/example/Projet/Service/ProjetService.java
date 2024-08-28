package com.example.Projet.Service;

import com.example.Projet.model.FullProjetResponse;
import com.example.Projet.model.Projet;

import java.util.List;

public interface ProjetService {
    // Méthode pour créer un nouveau projet
    Projet createProjet(Projet projet);

    // Méthode pour récupérer tous les projets existants
    List<Projet> getAllProjets();

    // Méthode pour mettre à jour un projet existant (ID de type int pour correspondre à l'entité Projet)
    Projet updateProjet(int id, Projet projet);

    // Méthode pour supprimer un projet par son ID
    void deleteProjet(int id);

    // Méthode pour récupérer un projet avec ses tâches associées
    FullProjetResponse projetWithTaches(int id); // Change Long to int
}
