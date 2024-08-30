package com.example.Taches.service;

import com.example.Taches.model.Taches;
import com.example.Taches.model.enums.Statut;
import com.example.Taches.repository.TachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TachesServiceImpl implements TachesService {

    @Autowired
    private TachesRepository tachesRepository;

    @Override
    public Taches ajouterTache(Taches taches) {
        taches.setStatut(Statut.A_FAIRE);
        return tachesRepository.save(taches);
    }

    @Override
    public Taches editTache(Long id, Taches taches) {
        Taches existingTache = tachesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        existingTache.setStatut(taches.getStatut());
        existingTache.setDescription(taches.getDescription());
        existingTache.setDateDebut(taches.getDateDebut());
        existingTache.setDateFin(taches.getDateFin());
        existingTache.setProjetId(taches.getProjetId());
        return tachesRepository.save(existingTache);
    }

    @Override
    public List<Taches> getAll() {
        return tachesRepository.findAll();
    }

    @Override
    public void deleteTaches(Long id) {
        tachesRepository.deleteById(id);
    }

    @Override
    public Taches changerStatut(Long id, Taches taches) {
        Taches existingTache = tachesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tâche non trouvée"));
        existingTache.setStatut(taches.getStatut());
        return tachesRepository.save(existingTache);
    }

    @Override
    public void deleteByProjetId(Long projetId) {
        List<Taches> taches = tachesRepository.findAllByProjetId(projetId);
        tachesRepository.deleteAll(taches);
    }

    @Override
    public List<Taches> getAllTachesByProjet(Long id) {
        return tachesRepository.findAllByProjetId(id);
    }
}
