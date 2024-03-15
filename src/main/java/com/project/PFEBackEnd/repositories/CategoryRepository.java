package com.project.PFEBackEnd.repositories;

import com.project.PFEBackEnd.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Long> {
}
