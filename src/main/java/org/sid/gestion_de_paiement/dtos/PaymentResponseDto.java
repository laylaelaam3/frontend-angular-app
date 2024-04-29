package org.sid.gestion_de_paiement.dtos;

import lombok.Data;
import org.sid.gestion_de_paiement.entities.PaymentStatus;
import org.sid.gestion_de_paiement.entities.PaymentType;

import java.time.LocalDate;
@Data
public class PaymentResponseDto {
    private Long id;
    private LocalDate date;
    private Double amount;
    private PaymentStatus status;
    private PaymentType type;
    private String file;
    private String etudiantCode;
}
