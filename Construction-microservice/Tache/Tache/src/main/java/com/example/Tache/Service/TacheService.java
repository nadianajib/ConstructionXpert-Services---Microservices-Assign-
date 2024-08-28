package com.example.Tache.Service;

import com.example.Tache.Dao.TacheRepository;
import com.example.Tache.model.Tache;
import lombok.var;

import java.util.List;

public interface TacheService {
    Tache createTache(Tache tache);
    List<Tache> getAllTaches();
     FullTacheResponse getAllTachesWithProjet(Integer tacheId);
     var tache = TacheRepository.
}
