package com.mutantes.mutant_detector.controller;

import com.mutantes.mutant_detector.DTO.StatsResponse;
import com.mutantes.mutant_detector.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;  //Si o si debemos inyectar el servicio
/*
    @GetMapping("/stats")
    public StatsResponse getStats() {
        long countMutantDna = statsService.getMutantCount();
        long countHumanDna = statsService.getHumanCount();

        double ratio = 0.0; //inicializo el ratio en 0.0

        if (countHumanDna > 0) { //para no dividir por 0
            ratio = (double) countMutantDna / countHumanDna;
        }

        return StatsResponse.builder() //builder de lombok
                .countMutantDna(countMutantDna)
                .countHumanDna(countHumanDna)
                .ratio(ratio)
                .build();
    }*/

    @GetMapping("/stats")
    public StatsResponse getStats() {
        return statsService.getStats(); //Llamada valida
    }

}
