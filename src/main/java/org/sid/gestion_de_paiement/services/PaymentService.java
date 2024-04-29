package org.sid.gestion_de_paiement.services;


import org.sid.gestion_de_paiement.dtos.PaymentResponseDto;
import org.sid.gestion_de_paiement.entities.Payment;
import org.sid.gestion_de_paiement.entities.PaymentStatus;
import org.sid.gestion_de_paiement.entities.PaymentType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PaymentService {
    PaymentResponseDto addPayment(String etudiantCode, Double amount, LocalDate date, MultipartFile file, PaymentType paymentType) throws IOException;
    List<PaymentResponseDto> findPaiementByStatus(PaymentStatus status);
    List<PaymentResponseDto>findPaiementByEtudiantCode(String code);
    List<PaymentResponseDto>findPaiementByType(PaymentType type);
    List<PaymentResponseDto> findAllPayment();
    PaymentResponseDto findPaymentById(Long id);
    PaymentResponseDto updatePaymentSatus(long id ,PaymentStatus paymentStatus);

}
