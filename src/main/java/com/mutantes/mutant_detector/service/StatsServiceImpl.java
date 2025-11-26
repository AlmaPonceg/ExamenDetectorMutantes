package com.mutantes.mutant_detector.service;

import com.mutantes.mutant_detector.DTO.StatsResponse;
import com.mutantes.mutant_detector.repository.DnaRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor  //crea constructor que falta

public class StatsServiceImpl implements StatsService {
    private final DnaRecordRepository repository; //Inyectamos la BD

    @Override
    public long getMutantCount(){
        return repository.countByIsMutant(true);
    }

    @Override
    public long  getHumanCount(){
        return repository.countByIsMutant(false);
    }

    //Metodo que lee la BD, mejora agregada

    public StatsResponse getStats() {
        long mutantes = getMutantCount();
        long humanos  = getHumanCount();
        double ratio  = (humanos == 0) ? (mutantes > 0 ? mutantes : 0.0)
                : (double) mutantes / humanos;

        return StatsResponse.builder()
                .countMutantDna(mutantes)
                .countHumanDna(humanos)
                .ratio(ratio)
                .build();
    }
}
