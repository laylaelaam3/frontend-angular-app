package org.sid.gestion_de_paiement.repositories;

import org.sid.gestion_de_paiement.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
   Optional<Etudiant>  findEtudiantByCode(String code);
  Optional<List<Etudiant>>findEtudiantByProgram(String program);


}
