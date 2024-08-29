package com.example.Projets.repository;

import com.example.Projets.model.Projets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetsRepository extends JpaRepository<Projets, Long> {
}
