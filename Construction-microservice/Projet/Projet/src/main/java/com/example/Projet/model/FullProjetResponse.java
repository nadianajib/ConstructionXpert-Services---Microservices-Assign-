
    package com.example.Projet.model;

import lombok.*;

import java.sql.Date;
import java.util.List;
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class FullProjetResponse {
        private String nomProjet;
        private String DateDebut;
        private String DateFin;
        private String description;
        private Double budget;
        private List<Tache> taches;
    }

