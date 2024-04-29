package org.sid.gestion_de_paiement.dtos;

import lombok.Data;

@Data

public class EtudiantRequestDto {
    private String firstName;
    private String lastName;
    private String photo;
    private String program;
    private String email;
}
