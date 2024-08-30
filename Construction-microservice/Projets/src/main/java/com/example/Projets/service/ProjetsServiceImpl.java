package com.example.Projets.service;

import com.example.Projets.client.TachesClient;
import com.example.Projets.model.FullProjetResponse;
import com.example.Projets.model.Projets;
import com.example.Projets.model.Taches;
import com.example.Projets.repository.ProjetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjetsServiceImpl implements ProjetsService{

    @Autowired
    ProjetsRepository projetsRepository;
    @Autowired
    TachesClient tachesClient;

    @Override
    public Projets ajouterProjet(Projets projet) {
        return projetsRepository.save(projet);
    }

    @Override
    public Projets modifierProjet(Long id, Projets projet) {
        Projets edited = new Projets();
        edited.setId(id);
        edited.setNom(projet.getNom());
        edited.setDescription(projet.getDescription());
        edited.setBudget(projet.getBudget());
        edited.setDateDebut(projet.getDateDebut());
        edited.setDateFin(projet.getDateFin());
        return projetsRepository.save(edited);
    }

    @Override
    public List<Projets> allProjets() {
        return projetsRepository.findAll();
    }



    @Override
    public FullProjetResponse projetWithTaches(Long id) {
        Projets projet = projetsRepository.findById(id)
                .orElse(
                        Projets.builder()
                                .nom("NOT_FOUND")
                                .build()
                );
        List<Taches> taches = tachesClient.findAllTachesByProjet(id);
        return FullProjetResponse.builder()
                .nom(projet.getNom())
                .dateDebut(projet.getDateDebut())
                .dateFin(projet.getDateFin())
                .description(projet.getDescription())
                .budget(projet.getBudget())
                .taches(taches)
                .build();
    }
    @Override
    public void supprimerProjet(Long id) {
        // Supprimer les tâches associées
        tachesClient.deleteByProjetId(id); // Utiliser le client Taches pour appeler le service Taches

        // Supprimer le projet
        projetsRepository.deleteById(id);
    }

}
