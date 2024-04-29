package org.sid.gestion_de_paiement.web;

import lombok.AllArgsConstructor;
import org.sid.gestion_de_paiement.dtos.PaymentResponseDto;
import org.sid.gestion_de_paiement.entities.PaymentStatus;
import org.sid.gestion_de_paiement.entities.PaymentType;
import org.sid.gestion_de_paiement.services.PaymentService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;
@PostMapping( consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PaymentResponseDto>  addPayment(@RequestBody  MultipartFile file ,String etudiantCode, Double amount, LocalDate date,  PaymentType paymentType) throws IOException {
        return ResponseEntity.ok(paymentService.addPayment(etudiantCode, amount, date, file, paymentType));
    }
@GetMapping("/{status}")
    public ResponseEntity<List<PaymentResponseDto>> findPaiementByStatus(@PathVariable PaymentStatus status) {
        return ResponseEntity.ok( paymentService.findPaiementByStatus(status));
    }
    @GetMapping("/{code}")

    public ResponseEntity< List<PaymentResponseDto>> findPaiementByEtudiantCode(String code) {
        return  ResponseEntity.ok(paymentService.findPaiementByEtudiantCode(code));
    }
    @GetMapping("/{type}")
    public ResponseEntity< List<PaymentResponseDto>> findPaiementByType(PaymentType type) {
        return ResponseEntity.ok(paymentService.findPaiementByType(type)) ;
    }
    @GetMapping("")
    public ResponseEntity< List<PaymentResponseDto>> findAllPayment() {
        return ResponseEntity.ok(paymentService.findAllPayment());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDto> findPaymentById(Long id) {
        return ResponseEntity.ok(paymentService.findPaymentById(id));
    }
@PutMapping("/{id}")
    public ResponseEntity<PaymentResponseDto >updatePaymentSatus(@PathVariable long id, @RequestParam PaymentStatus paymentStatus) {
        return ResponseEntity.ok(paymentService.updatePaymentSatus(id, paymentStatus));
    }
}
