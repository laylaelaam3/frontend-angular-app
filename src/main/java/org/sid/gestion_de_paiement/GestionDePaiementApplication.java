package org.sid.gestion_de_paiement;

import lombok.AllArgsConstructor;
import org.sid.gestion_de_paiement.entities.Etudiant;
import org.sid.gestion_de_paiement.entities.Payment;
import org.sid.gestion_de_paiement.entities.PaymentStatus;
import org.sid.gestion_de_paiement.entities.PaymentType;
import org.sid.gestion_de_paiement.repositories.EtudiantRepository;
import org.sid.gestion_de_paiement.repositories.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@AllArgsConstructor
public class GestionDePaiementApplication implements CommandLineRunner {
	private final EtudiantRepository etudiantRepository;
	private final PaymentRepository paymentRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestionDePaiementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Etudiant etudiant1 = Etudiant.builder()
				.firstName("John")
				.lastName("Doe")
				.email("john.doe@example.com")
				.photo("photo1")
				.code(UUID.randomUUID().toString())
				.program("SIAD")

				.build();
		etudiantRepository.save(etudiant1);

		// Étudiant 2
		Etudiant etudiant2 = Etudiant.builder()
				.firstName("Alice")
				.lastName("Smith")
				.email("alice.smith@example.com")
				.photo("photo2")
				.code(UUID.randomUUID().toString())
				.program("SIADM")

				.build();
		etudiantRepository.save(etudiant2);

		// Étudiant 3
		Etudiant etudiant3 = Etudiant.builder()
				.firstName("Michael")
				.lastName("Johnson")
				.email("michael.johnson@example.com")
				.photo("photo3")
				.code(UUID.randomUUID().toString())
				.program("IEGC")

				.build();
		etudiantRepository.save(etudiant3);

		// Étudiant 4
		Etudiant etudiant4 = Etudiant.builder()
				.firstName("Emma")
				.lastName("Brown")
				.email("emma.brown@example.com")
				.photo("photo4")
				.code(UUID.randomUUID().toString())
				.program("SIAD")

				.build();
		etudiantRepository.save(etudiant4);

		// Étudiant 5
		Etudiant etudiant5 = Etudiant.builder()
				.firstName("William")
				.lastName("Jones")
				.email("william.jones@example.com")
				.photo("photo5")
				.code(UUID.randomUUID().toString())
				.program("SIADM")

				.build();
		etudiantRepository.save(etudiant5);
		Payment payment = Payment.builder()
				.date(LocalDate.now())
				.type(PaymentType.CHECK)
				.file("Bootsrap certificate.pdf")
				.amount(15000.00)
				.status(PaymentStatus.VALIDATED)
				.etudiant(etudiant1)
				.build();
		paymentRepository.save(payment);
		// Premier objet Payment
		Payment payment1 = Payment.builder()
				.date(LocalDate.of(2024, 4, 26))
				.type(PaymentType.CHECK)
				.file("file1.pdf")
				.amount(15000.00)
				.status(PaymentStatus.VALIDATED)
				.etudiant(etudiant1)
				.build();

// Deuxième objet Payment
		Payment payment2 = Payment.builder()
				.date(LocalDate.of(2024, 4, 27)) // Date du paiement
				.type(PaymentType.DEPOSIT) // Type de paiement
				.file("file2.pdf") // Nom du fichier
				.amount(20000.00) // Montant du paiement
				.status(PaymentStatus.CREATED) // Statut du paiement
				.etudiant(etudiant2) // Etudiant associé
				.build();

// Troisième objet Payment
		Payment payment3 = Payment.builder()
				.date(LocalDate.of(2024, 4, 28)) // Date du paiement
				.type(PaymentType.CASH) // Type de paiement
				.file("file3.pdf") // Nom du fichier
				.amount(18000.00) // Montant du paiement
				.status(PaymentStatus.REJECTED) // Statut du paiement
				.etudiant(etudiant3) // Etudiant associé
				.build();

// Quatrième objet Payment
		Payment payment4 = Payment.builder()
				.date(LocalDate.of(2024, 4, 29)) // Date du paiement
				.type(PaymentType.CHECK) // Type de paiement
				.file("file4.pdf") // Nom du fichier
				.amount(25000.00) // Montant du paiement
				.status(PaymentStatus.VALIDATED) // Statut du paiement
				.etudiant(etudiant4) // Etudiant associé
				.build();

	}


}
