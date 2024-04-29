package org.sid.gestion_de_paiement.repositories;

import org.sid.gestion_de_paiement.entities.Payment;
import org.sid.gestion_de_paiement.entities.PaymentStatus;
import org.sid.gestion_de_paiement.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    Optional<List<Payment>>findPaiementByStatus(PaymentStatus status);
    Optional<List<Payment>>findPaiementByEtudiantCode(String code);
    Optional<List<Payment>>findPaiementByType(PaymentType type);
}
