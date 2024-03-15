package com.project.PFEBackEnd.controllers;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.project.PFEBackEnd.entities.Commentaire;
import com.project.PFEBackEnd.repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/commentaires")
public class CommentaireController {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @GetMapping
    public List<Commentaire> getAllCommentaires() {
        return commentaireRepository.findAll();
    }

    @GetMapping("/{id}")
    public Commentaire getCommentaireById(@PathVariable Long id) {
        return commentaireRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Commentaire saveCommentaire(@RequestBody Commentaire commentaire) {
        return commentaireRepository.save(commentaire);
    }

    @PutMapping("/{id}")
    public Commentaire updateCommentaire(@PathVariable Long id, @RequestBody Commentaire commentaireDetails) {
        Commentaire commentaire = commentaireRepository.findById(id).orElse(null);
        if (commentaire != null) {
            commentaire.setContent(commentaireDetails.getContent());
            // Si votre entité Commentaire a d'autres champs, vous pouvez les mettre à jour de la même manière
            // commentaire.setAutreChamp(commentaireDetails.getAutreChamp());
            return commentaireRepository.save(commentaire);
        }
        return null; // Ou lancez une exception si le commentaire n'est pas trouvé
    }


    @DeleteMapping("/{id}")
    public void deleteCommentaire(@PathVariable Long id) {
        commentaireRepository.deleteById(id);
    }
}

