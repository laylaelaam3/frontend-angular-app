package org.sid.gestion_de_paiement.services;

import org.sid.gestion_de_paiement.dtos.EtudiantRequestDto;
import org.sid.gestion_de_paiement.dtos.EtudiantResponseDto;
import org.sid.gestion_de_paiement.entities.Etudiant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface EtudiantService {
    EtudiantResponseDto addEtudiant(EtudiantRequestDto etudiantRequestDto);
    EtudiantResponseDto findEtudiantById(Long id);
    List<EtudiantResponseDto> findAllEtudiants();
    EtudiantResponseDto updateEtudiant(Long id,EtudiantRequestDto etudiantRequestDto);
    void deleteEtudiant(Long id);
   EtudiantResponseDto findEtudiantByCode(String code);
    List<EtudiantResponseDto>findEtudiantByProgrameId(String program);


}
