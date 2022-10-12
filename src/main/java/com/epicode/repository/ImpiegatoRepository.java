package com.epicode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.epicode.modello.Impiegato;

@Repository
public interface ImpiegatoRepository extends JpaRepository<Impiegato, Long>{

}
