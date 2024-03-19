package com.project.PFEBackEnd.services;

import com.project.PFEBackEnd.entities.Utilisateur;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<Utilisateur> getAllUsers();
    Utilisateur createUser(Utilisateur user);
    Utilisateur updateUser(Utilisateur user);
    void deleteUser(Long id);
    Utilisateur findById(Long id);
    Optional<Utilisateur> findByUserName(String username);
    UserDetails loadUserByUsername(String username);
}
