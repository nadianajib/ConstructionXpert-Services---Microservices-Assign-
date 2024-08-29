package com.example.Taches.repository;

import com.example.Taches.model.Taches;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TachesRepository extends JpaRepository<Taches, Long> {
    List<Taches> findAllByProjetId(Long id);
}
