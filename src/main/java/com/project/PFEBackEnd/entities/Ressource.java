package com.project.PFEBackEnd.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data


@Entity
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ref;

    private String description ;

    @JsonIgnore
    @ManyToOne
    private Formation formation ;

    public Formation getFormation() {
        return formation;
    }


}
