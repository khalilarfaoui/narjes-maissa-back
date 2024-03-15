package com.project.PFEBackEnd.controllers;

import com.project.PFEBackEnd.entities.Ressource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;



import com.project.PFEBackEnd.entities.Formation;
import com.project.PFEBackEnd.repositories.FormationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formations")
public class FormationController {

  @Autowired
  private FormationRepository formationRepository;

  @GetMapping
  public List<Formation> getAllFormations() {
    return formationRepository.findAll();
  }

  @GetMapping("/{id}")
  public Formation getFormationById(@PathVariable Long id) {
    Optional<Formation> formation = formationRepository.findById(id);
    return formation.orElse(null);
  }

  @PostMapping
  public Formation saveFormation(@RequestBody Formation formation) {
    return formationRepository.save(formation);
  }

  @DeleteMapping("/{id}")
  public void deleteFormation(@PathVariable Long id) {
    formationRepository.deleteById(id);
  }


  @GetMapping("getAllRessourcesByFormation/{idFormation}")
  public List<Ressource> getAllRessourcesByFormation(@PathVariable long idFormation){
    Formation formation = formationRepository.findById(idFormation).orElse(null);
    return formation.getRessourceList();
  }
}
