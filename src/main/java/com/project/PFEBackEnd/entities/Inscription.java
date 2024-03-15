package com.project.PFEBackEnd.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private Date inscriptionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formation_id")
    private Formation formation;


}

