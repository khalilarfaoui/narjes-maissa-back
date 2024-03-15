package com.project.PFEBackEnd.entities;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cours {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String titre;
  private String description;

  // Getters et setters
}

