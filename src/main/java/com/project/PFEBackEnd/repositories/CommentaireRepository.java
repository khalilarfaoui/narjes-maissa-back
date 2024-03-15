package com.project.PFEBackEnd.repositories;

import com.project.PFEBackEnd.entities.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
}
