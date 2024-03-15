package com.project.PFEBackEnd.controllers;


import com.project.PFEBackEnd.entities.Contenu;
import com.project.PFEBackEnd.repositories.ContenuReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contenus")
public class ContenuController {


    @Autowired
    private ContenuReporitory contenuReporitory ;





    @GetMapping("/getAll")
    public List<Contenu> getContenu(){
        return contenuReporitory.findAll() ;
    }


}
