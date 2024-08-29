
package com.example.Resources.Service;


import com.example.Resources.model.Ressources;

import java.util.List;

public interface RessourcesService {
    Ressources ajouterRessource (Ressources ressources);
    Ressources editRessources (Long id, Ressources ressources);
    List<Ressources> getAllRessources ();
    void deleteRessources(Long id);
    List<Ressources> getRessourcesByTache(Long id);
}
