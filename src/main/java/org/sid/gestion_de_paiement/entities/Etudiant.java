package org.sid.gestion_de_paiement.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    @Table(name = "Etudiant")
    public class Etudiant {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "etudiant_id")
        private Long id;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "email")
        private String email;

        @Column(name = "etudiant_code", unique = true)
        private String code;

        @Column(name = "photo")
        private String photo;

        @Column(name = "program")
        private String program;

        @OneToMany(mappedBy ="etudiant", cascade = CascadeType.ALL)
        List<Payment> paymentList;
    }

