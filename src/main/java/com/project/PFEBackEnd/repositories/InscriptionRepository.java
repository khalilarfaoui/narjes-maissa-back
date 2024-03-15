package com.project.PFEBackEnd.repositories;

import com.project.PFEBackEnd.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
