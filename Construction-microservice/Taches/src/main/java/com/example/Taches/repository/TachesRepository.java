package com.example.Taches.repository;

import com.example.Taches.model.Taches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TachesRepository extends JpaRepository<Taches, Long> {
    List<Taches> findAllByProjetId(Long id);


}
