package com.project.PFEBackEnd.repositories;

import com.project.PFEBackEnd.entities.Contenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenuReporitory extends JpaRepository<Contenu,Long> {
}
