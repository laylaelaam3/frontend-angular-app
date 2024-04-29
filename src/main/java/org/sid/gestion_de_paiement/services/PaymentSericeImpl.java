package org.sid.gestion_de_paiement.services;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sid.gestion_de_paiement.dtos.PaymentResponseDto;
import org.sid.gestion_de_paiement.entities.Etudiant;
import org.sid.gestion_de_paiement.entities.Payment;
import org.sid.gestion_de_paiement.entities.PaymentStatus;
import org.sid.gestion_de_paiement.entities.PaymentType;
import org.sid.gestion_de_paiement.mappers.MappingProfiles;
import org.sid.gestion_de_paiement.repositories.EtudiantRepository;
import org.sid.gestion_de_paiement.repositories.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PaymentSericeImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final EtudiantRepository etudiantRepository;


    @Override
    public PaymentResponseDto addPayment(String etudiantCode, Double amount, LocalDate date, MultipartFile file, PaymentType paymentType) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"),"ark-data","payment");
        if (!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName=UUID.randomUUID().toString();
        Path filederPath = Paths.get(System.getProperty("user.home"),"ark-data","payment",fileName+".pdf");
        Files.copy(file.getInputStream(),filederPath);
        Etudiant etudiant=etudiantRepository.findEtudiantByCode(etudiantCode).get();
        Payment payment=Payment.builder()
                .amount(amount)
                .date(date)
                .type(paymentType)
                .status(PaymentStatus.CREATED)
                .etudiant(etudiant)
                .file(filederPath.toUri().toString())
                .build();

        return MappingProfiles.mapToDto(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentResponseDto> findPaiementByStatus(PaymentStatus status) {
        List<Payment> paymentList=paymentRepository.findPaiementByStatus(status).get();
        return paymentList.stream().map(MappingProfiles::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDto> findPaiementByEtudiantCode(String code) {
        List<Payment> paymentList=paymentRepository.findPaiementByEtudiantCode(code).get();
        return paymentList.stream().map(MappingProfiles::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDto> findPaiementByType(PaymentType type) {
        List<Payment> paymentList=paymentRepository.findPaiementByType(type).get();
        return paymentList.stream().map(MappingProfiles::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<PaymentResponseDto> findAllPayment() {
        return paymentRepository.findAll().stream().map(MappingProfiles::mapToDto).collect(Collectors.toList());
    }

    @Override
    public PaymentResponseDto findPaymentById(Long id) {
        Payment payment=paymentRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        return MappingProfiles.mapToDto(payment);
    }

    @Override
    public PaymentResponseDto updatePaymentSatus(long id, PaymentStatus paymentStatus) {
        Payment payment=paymentRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        payment.setStatus(paymentStatus);
        return MappingProfiles.mapToDto(payment);
    }
}
