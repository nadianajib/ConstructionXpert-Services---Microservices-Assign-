package com.example.Tache.Dao;

import com.example.Tache.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findAllByProjetId(int id);

}
