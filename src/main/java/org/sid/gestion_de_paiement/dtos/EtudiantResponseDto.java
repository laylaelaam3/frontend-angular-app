package org.sid.gestion_de_paiement.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class EtudiantResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String code;
    private String photo;
    private String program;
}
