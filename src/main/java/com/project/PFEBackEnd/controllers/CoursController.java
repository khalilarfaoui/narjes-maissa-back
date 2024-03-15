package com.project.PFEBackEnd.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;


import com.project.PFEBackEnd.entities.Cours;
import com.project.PFEBackEnd.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/cours")
public class CoursController {

  @Autowired
  private CoursRepository CoursRepository;

  @GetMapping
  public List<Cours> getAllCours() {
    return CoursRepository.findAll();
  }

  @GetMapping("/{id}")
  public Cours getCoursById(@PathVariable Long id) {
    return CoursRepository.findById(id).orElse(null);
  }

  @PostMapping
  public Cours saveCours(@RequestBody Cours cours) {
    return CoursRepository.save(cours);
  }

  @PutMapping("/{id}")
  public Cours updateCours(@PathVariable Long id, @RequestBody Cours coursDetails) {
    Cours cours = CoursRepository.findById(id).orElse(null);
    if (cours != null) {
      cours.setTitre(coursDetails.getTitre());
      cours.setDescription(coursDetails.getDescription());
      CoursRepository.save(cours);
    }
    return cours;
  }

  @DeleteMapping("/{id}")
  public void deleteCours(@PathVariable Long id) {
    CoursRepository.deleteById(id);
  }
}

