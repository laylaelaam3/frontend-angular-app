package org.sid.gestion_de_paiement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.sid.gestion_de_paiement.entities.Etudiant;
import org.sid.gestion_de_paiement.entities.PaymentType;

import java.time.LocalDate;
@Data

public class PaymentRequestDto {
    private LocalDate date;
    private Double amount;
    private PaymentType type;
    private String file;
    private String etudiantCode;
}
