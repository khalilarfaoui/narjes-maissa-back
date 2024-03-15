package com.project.PFEBackEnd.repositories;



import com.project.PFEBackEnd.entities.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
