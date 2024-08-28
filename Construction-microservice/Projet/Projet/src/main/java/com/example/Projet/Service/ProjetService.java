package com.example.Projet.Service;

import com.example.Projet.Dao.ProjetRepository;
import com.example.Projet.model.Projet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjetService {

    private final ProjetRepository projetRepository;

    public Projet saveProjet(Projet projet) {
        projetRepository.save(projet);
        return projet;
    }
    public List<Projet> findAllProjets() {
        return projetRepository.findAll();
    }
    public Projet updateProjet(Long id, Projet projet) {
        if(projetRepository.existsById(projet.getIdProjet())) {
            projetRepository.save(projet);
        }
        return projet;
    }
    public void deleteProjet(int id) {
        projetRepository.deleteById(id);
    }

}