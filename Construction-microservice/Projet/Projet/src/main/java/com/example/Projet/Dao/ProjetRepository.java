package com.example.Projet.Dao;

import com.example.Projet.model.Projet;
import com.example.Projet.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
}

