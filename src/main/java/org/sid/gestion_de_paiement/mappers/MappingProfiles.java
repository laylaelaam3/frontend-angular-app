package org.sid.gestion_de_paiement.mappers;

import org.modelmapper.ModelMapper;
import org.sid.gestion_de_paiement.dtos.EtudiantRequestDto;
import org.sid.gestion_de_paiement.dtos.EtudiantResponseDto;
import org.sid.gestion_de_paiement.dtos.PaymentRequestDto;
import org.sid.gestion_de_paiement.dtos.PaymentResponseDto;
import org.sid.gestion_de_paiement.entities.Etudiant;
import org.sid.gestion_de_paiement.entities.Payment;

public class MappingProfiles {
    public static final ModelMapper modelMapper= new ModelMapper();
    public static Payment mapToEntity(PaymentRequestDto paimentRequestDto){
       return modelMapper.map(paimentRequestDto, Payment.class);
    }
    public static PaymentResponseDto mapToDto(Payment paiement){
        return modelMapper.map(paiement, PaymentResponseDto.class);
    }
    public static Etudiant mapToEntity(EtudiantRequestDto etudiantRequestDto){
        return modelMapper.map(etudiantRequestDto,Etudiant.class);
    }
    public static EtudiantResponseDto mapToDto(Etudiant etudiant){
        return modelMapper.map(etudiant,EtudiantResponseDto.class);
    }
}
