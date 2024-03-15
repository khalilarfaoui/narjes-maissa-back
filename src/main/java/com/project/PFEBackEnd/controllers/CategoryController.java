package com.project.PFEBackEnd.controllers;

import com.project.PFEBackEnd.entities.Category;
import com.project.PFEBackEnd.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("getAll")
    public List<Category> getAllCatgories (){
        return categoryRepository.findAll();
    }


    @PostMapping("create")
    public Category saveCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
