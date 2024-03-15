package com.project.PFEBackEnd.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Formation {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  private String name;
  private String description;
  private LocalDateTime date ;
  private int nbMax ;

  private TypeFormation type ;

  @OneToMany
  private List<Ressource> ressourceList ;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "formation")
  private List<Commentaire> commentaireList;

  @OneToMany(mappedBy = "formation")
  private List<Inscription> inscriptions;
  public void setRessourceToFormation(Ressource ressource) {
    this.ressourceList.add(ressource);
  }
}
