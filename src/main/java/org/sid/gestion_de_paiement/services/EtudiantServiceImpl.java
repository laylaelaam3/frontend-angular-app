package org.sid.gestion_de_paiement.services;

import lombok.AllArgsConstructor;
import org.sid.gestion_de_paiement.dtos.EtudiantRequestDto;
import org.sid.gestion_de_paiement.dtos.EtudiantResponseDto;
import org.sid.gestion_de_paiement.entities.Etudiant;
import org.sid.gestion_de_paiement.mappers.MappingProfiles;
import org.sid.gestion_de_paiement.repositories.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService{
    private final EtudiantRepository etudiantRepository;
    @Override
    public EtudiantResponseDto addEtudiant(EtudiantRequestDto etudiantRequestDto) {
        Etudiant etudiant= MappingProfiles.mapToEntity(etudiantRequestDto);
        etudiant.setCode(UUID.randomUUID().toString());
        return MappingProfiles.mapToDto(etudiantRepository.save(etudiant));
    }

    @Override
    public EtudiantResponseDto findEtudiantById(Long id) {
        Etudiant etudiant=etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        return MappingProfiles.mapToDto(etudiant);
    }

    @Override
    public List<EtudiantResponseDto> findAllEtudiants() {
        return etudiantRepository.findAll().stream().map(MappingProfiles::mapToDto).collect(Collectors.toList());
    }

    @Override
    public EtudiantResponseDto updateEtudiant(Long id, EtudiantRequestDto etudiantRequestDto) {
        Etudiant etudiant=etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        etudiant.setEmail(etudiantRequestDto.getEmail());
        etudiant.setPhoto(etudiantRequestDto.getPhoto());
        etudiant.setFirstName(etudiantRequestDto.getFirstName());
        etudiant.setLastName(etudiant.getLastName());
        return MappingProfiles.mapToDto(etudiant);
    }

    @Override
    public void deleteEtudiant(Long id) {
        Etudiant etudiant=etudiantRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        etudiantRepository.delete(etudiant);



    }

    @Override
    public EtudiantResponseDto findEtudiantByCode(String code) {
        Etudiant etudiant=etudiantRepository.findEtudiantByCode(code).orElseThrow(() -> new RuntimeException(""));
        return MappingProfiles.mapToDto(etudiant);


    }

    @Override
    public List<EtudiantResponseDto> findEtudiantByProgrameId(String program) {
        List<Etudiant>etudiantList=etudiantRepository.findEtudiantByProgram(program).orElseThrow(() -> new RuntimeException(""));

        return etudiantList.stream().map(MappingProfiles::mapToDto).collect(Collectors.toList());
    }



}

