package com.example.Tache.Dao;

import com.example.Tache.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepository extends JpaRepository<Tache, Long> {
}
