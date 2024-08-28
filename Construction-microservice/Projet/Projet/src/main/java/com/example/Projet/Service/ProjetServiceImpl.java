package com.example.Projet.Service;

import com.example.Projet.Dao.ProjetRepository;
import com.example.Projet.model.FullProjetResponse;
import com.example.Projet.model.Projet;
import com.example.Projet.model.Tache;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetServiceImpl implements ProjetService {

    private final ProjetRepository projetRepository;
    private final TacheRepository tacheRepository;


    @Override
    public Projet createProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public List<Projet> getAllProjets() {
        return projetRepository.findAll();
    }

    @Override
    public Projet updateProjet(int id, Projet projet) { // Change Long to int
        // Recherche du projet par son ID
        Optional<Projet> existingProjet = projetRepository.findById(id); // Change Long to int
        if (existingProjet.isPresent()) {
            // Mise à jour des détails du projet existant
            Projet projetToUpdate = existingProjet.get();
            projetToUpdate.setNomProjet(projet.getNomProjet());
            projetToUpdate.setDescription(projet.getDescription());
            projetToUpdate.setDateDebut(projet.getDateDebut());
            projetToUpdate.setDateFin(projet.getDateFin());
            projetToUpdate.setBudget(projet.getBudget());

            // Sauvegarder les modifications
            return projetRepository.save(projetToUpdate);
        } else {
            // Gérer le cas où le projet n'est pas trouvé (exception, message d'erreur, etc.)
            throw new RuntimeException("Projet non trouvé avec l'ID : " + id);
        }
    }

    @Override
    public void deleteProjet(int id) {
        projetRepository.deleteById(id);
    }

    @Override
    public FullProjetResponse projetWithTaches(int id) {
        Projet projet = projetRepository.findById(id)
                .orElse(Projet.builder().nomProjet("Not_Found").build());

        // Utilisez le TacheRepository pour récupérer les tâches associées au projet
        List<Tache> tache = tacheRepository.findAllByProjetId(id); // Assurez-vous que cette méthode existe dans TacheRepository

        return FullProjetResponse.builder()
                .nomProjet(projet.getNomProjet())
                .DateDebut(projet.getDateDebut())
                .DateFin(projet.getDateFin())
                .description(projet.getDescription())
                .budget(projet.getBudget())
                .taches(tache)
                .build();
    }
    }

