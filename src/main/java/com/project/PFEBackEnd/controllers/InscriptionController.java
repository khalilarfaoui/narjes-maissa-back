package com.project.PFEBackEnd.controllers;

import com.project.PFEBackEnd.entities.StatusInscription;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.project.PFEBackEnd.entities.Inscription;
import com.project.PFEBackEnd.repositories.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/Inscription")
public class InscriptionController {


    @Autowired
    private InscriptionRepository inscriptionRepository;

    @PostMapping
    public Inscription createInscription(@RequestBody Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Inscription getInscriptionById(@PathVariable Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Inscription updateInscription(@PathVariable Long id, @RequestBody Inscription inscriptionDetails) {
        Inscription inscription = inscriptionRepository.findById(id).orElse(null);
        if (inscription != null) {
            inscription.setNom(inscriptionDetails.getNom());
            inscription.setPrenom(inscriptionDetails.getPrenom());
            inscription.setEmail(inscriptionDetails.getEmail());
            return inscriptionRepository.save(inscription);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteInscription(@PathVariable Long id) {
        inscriptionRepository.deleteById(id);
    }


}

