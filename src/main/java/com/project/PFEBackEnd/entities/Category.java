package com.project.PFEBackEnd.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;

    private String label ;
  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Formation> formations;
}
