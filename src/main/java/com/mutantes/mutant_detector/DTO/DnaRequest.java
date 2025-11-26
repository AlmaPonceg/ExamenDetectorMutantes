package com.mutantes.mutant_detector.DTO;

import com.mutantes.mutant_detector.exception.ValidDnaSequence;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor  //Necesario para jackson
@AllArgsConstructor   //Necesario para crear desde codigo/test
public class DnaRequest {

    @NotNull(message = "EL ADN no puede ser nulo")
    @ValidDnaSequence // Esta validacion la creamos
    private String [] dna;


}

