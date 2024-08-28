package com.example.Tache.Service;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Projet {
    private String nomProjet;
    private String DateDebut;
    private String DateFin;
    private Double budget;
}
