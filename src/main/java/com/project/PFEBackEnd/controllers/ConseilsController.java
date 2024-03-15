package com.project.PFEBackEnd.controllers;

import org.springframework.web.bind.annotation.*;


import com.project.PFEBackEnd.entities.Conseils;
import com.project.PFEBackEnd.repositories.ConseilsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/conseils")
public class ConseilsController {

  @Autowired
  private ConseilsRepository conseilsRepository;

  @GetMapping
  public List<Conseils> getAllConseils() {
    return conseilsRepository.findAll();
  }

  @GetMapping("/{id}")
  public Conseils getConseilsById(@PathVariable Long id) {
    return conseilsRepository.findById(id).orElse(null);
  }

  @PostMapping
  public Conseils saveConseils(@RequestBody Conseils conseils) {
    return conseilsRepository.save(conseils);
  }

  @PutMapping("/{id}")
  public Conseils updateConseils(@PathVariable Long id, @RequestBody Conseils conseilsDetails) {
    Conseils conseils = conseilsRepository.findById(id).orElse(null);
    if (conseils != null) {
      conseils.setTitre(conseilsDetails.getTitre());
      conseils.setDescription(conseilsDetails.getDescription());
      conseils.setType(conseilsDetails.getType());
      conseilsRepository.save(conseils);
    }
    return conseils;
  }

  @DeleteMapping("/{id}")
  public void deleteConseils(@PathVariable Long id) {
    conseilsRepository.deleteById(id);
  }
}

