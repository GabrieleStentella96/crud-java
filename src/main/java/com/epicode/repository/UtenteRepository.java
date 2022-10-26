package com.epicode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.modello.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
  Optional<Utente> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}