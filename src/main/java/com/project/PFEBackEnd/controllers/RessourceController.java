package com.project.PFEBackEnd.controllers;

import com.project.PFEBackEnd.entities.Formation;
import com.project.PFEBackEnd.entities.Ressource;
import com.project.PFEBackEnd.repositories.FormationRepository;
import com.project.PFEBackEnd.repositories.RessourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("ressources")
@RestController
public class RessourceController {

    @Autowired
    RessourceRepository ressourceRepository;

    @Autowired
    FormationRepository formationRepository;


    @GetMapping("getAll")
    public List<Ressource> getAllRessources(){
        return ressourceRepository.findAll() ;
    }


    @PostMapping("create")
    public Ressource saveRess(@RequestBody Ressource ressource){
        return ressourceRepository.save(ressource);
    }



    @PostMapping("createByFormation/{idFormation}")
    public ResponseEntity<?> saveRessource(@RequestBody Ressource ressource , @PathVariable long idFormation){
        Formation formation = formationRepository.findById(idFormation).orElse(null);
        if(formation == null){
           return ResponseEntity.notFound().build();
        }
        try {
            Ressource c = ressourceRepository.save(ressource);
            formation.setRessourceToFormation(c);
            formation.setId(idFormation);
            formationRepository.save(formation);
            return ResponseEntity.ok(c) ;
        }catch (Error err){
            return ResponseEntity.badRequest().build();
        }
    }

   /* @GetMapping("getFormationByRessource/{idRessouce}")
    public Formation getFormationByRessource(@PathVariable long idRessouce){
        Ressource ressource = ressourceRepository.findById(idRessouce).orElse(null);

        return ressource.getFormation();
    }*/
}
