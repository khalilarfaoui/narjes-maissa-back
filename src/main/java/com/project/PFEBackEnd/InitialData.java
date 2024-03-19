package com.project.PFEBackEnd;

import com.project.PFEBackEnd.entities.Role;
import com.project.PFEBackEnd.entities.Utilisateur;
import com.project.PFEBackEnd.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements CommandLineRunner {

    @Autowired
    IUserService userService;
    @Override
    public void run(String... args) throws Exception {

        if(userService.findByUserName("admin").isPresent()){
            System.out.println("nothing change");
        }else {
            Utilisateur admin = new Utilisateur();
            admin.setUserName("admin");
            admin.setPassword("12369**");
            admin.setFirstName("Administrateur");
            admin.setLastName("global");
            admin.setEmail("admin@gmail.com");
            admin.setPhone("00000000");
            admin.setRole(Role.ADMIN);

            userService.createUser(admin);
            System.out.println("admin added successfully");
        }


    }
}
