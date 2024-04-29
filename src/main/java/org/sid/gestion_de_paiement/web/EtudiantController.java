package org.sid.gestion_de_paiement.web;

import lombok.AllArgsConstructor;
import org.sid.gestion_de_paiement.dtos.EtudiantRequestDto;
import org.sid.gestion_de_paiement.dtos.EtudiantResponseDto;
import org.sid.gestion_de_paiement.services.EtudiantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiants")
public class EtudiantController {
    private final EtudiantService etudiantService;

    @PostMapping("")
    public ResponseEntity<EtudiantResponseDto> addEtudiant(@RequestBody EtudiantRequestDto etudiantRequestDto) {
        return ResponseEntity.ok(etudiantService.addEtudiant(etudiantRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantResponseDto> findEtudiantById(@PathVariable Long id) {
        return ResponseEntity.ok(etudiantService.findEtudiantById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<EtudiantResponseDto>> findAllEtudiants() {
        return ResponseEntity.ok(etudiantService.findAllEtudiants());
    }

    @PutMapping("/{id}")
    public EtudiantResponseDto updateEtudiant(@PathVariable Long id, @RequestBody EtudiantRequestDto etudiantRequestDto) {
        return etudiantService.updateEtudiant(id, etudiantRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<EtudiantResponseDto> findEtudiantByCode(@PathVariable String code) {
        return ResponseEntity.ok(etudiantService.findEtudiantByCode(code));
    }

    @GetMapping("/programme/{programmeId}")
    public ResponseEntity<List<EtudiantResponseDto>> findEtudiantByProgram(@PathVariable String program) {
        return ResponseEntity.ok(etudiantService.findEtudiantByProgrameId(program));
    }
}
