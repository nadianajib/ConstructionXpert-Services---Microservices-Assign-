package com.example.Projet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Projet {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idProjet;
private String nomProjet;
private String DateDebut;
private String DateFin;
private String description;
private Double budget;

}
